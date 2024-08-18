package com.net.alkye.di

import com.net.alkye.utils.NetworkUtil
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    /*@Binds
    @Singleton
    abstract fun provideArticlesRepository (
//        articlesRepositoryImpl: ArticlesRepositoryImpl
    ): ArticlesRepository*/
}