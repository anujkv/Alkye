package com.net.alkye.data.remote

import retrofit2.http.GET

interface AppApiServices {
    companion object {
        const val BASE_URL = "https://api.alkye.org/3/"
    }

    @GET("app/articles")
    suspend fun getArticles(): ArticlesResponse



}