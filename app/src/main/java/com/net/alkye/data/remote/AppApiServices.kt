package com.net.alkye.data.remote

import retrofit2.http.GET

interface AppApiServices {

    @GET("app/articles")
    suspend fun getArticles(): ArticlesResponse

    companion object {
        const val BASE_URL = "https://api.alkye.org/3/"
        const val API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
        const val ACCESS_TOKEN_KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmODY2MWZhODRmODM4MzcwOGY1YjQ4MTliMTNjNzg2ZCIsInN1YiI6IjY0MTk0ZTQyNTY5MGI1MDBhMjE4OWI2MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VvmqK7spX6cceJ4OL0TFAXXLfKa-dAvKXJLDeyh_Kf8"
    }

}