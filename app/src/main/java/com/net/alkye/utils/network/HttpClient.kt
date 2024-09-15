package com.net.alkye.utils.network

import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MockHttpClient {
    private var accessToken = "mock-access-token"
    private val refreshAccessToken = "mock-refresh-token"

    private val client: OkHttpClient

    init {
        // Create Mock Public Key Pinning
        val publicKey = "sha/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA="
        val certificatePinner = CertificatePinner.Builder()
            .add("mockserver.com",publicKey)// Pin the mock public key
            .build()

        // Setup OkHttpClient with SSL pinning and AuthInterceptor
        client = OkHttpClient.Builder()
            .certificatePinner(certificatePinner)
            .addInterceptor(AuthInterceptor())
            .build()

    }

    fun makeRequest(url: String){
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use {
            response ->
            if(response.isSuccessful) {
                println("Request successful with body ${response.body}")
            }else {
                println("Request failed with code ${response.code}")
            }
        }
    }

    // Inner class for token refreshing
    inner class AuthInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()

            var response = chain.proceed(request)

            if(response.code == NetworkCodes.UNAUTHORIZED){
                synchronized(this) {
                    //refresh token
                    accessToken = refreshAccessToken

                    //retry the request with the new token
                    request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $accessToken")
                        .build()

                    response = chain.proceed(request)
                }
            }

            return response
        }

        //Simulate refresh access token
        private fun refreshAccessToken(): String {
            println("Token Expired : $accessToken, \nrefreshing token... : $refreshAccessToken")
            return "new-access-token"
        }

    }
}




