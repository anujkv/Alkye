package com.net.alkye.di

import com.net.alkye.data.remote.AppApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    private val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesArticleApi() : AppApiServices {
        return Retrofit.Builder()
            .baseUrl(AppApiServices.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(AppApiServices::class.java)
    }

    /*@Provides
    @Singleton
    fun provideAppArticlesDatabase(app: Application): ArticlesDatabase {
        return Room.databaseBuilder(
                app,
                ArticlesDatabase::class.java,
            "app_articles_db"
        ).build()
    }*/
}