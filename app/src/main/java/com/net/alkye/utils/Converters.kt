package com.net.alkye.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.net.alkye.data.remote.CarouselArticle
import com.net.alkye.data.remote.RecentArticle


class Converters {

    /*Convert List<CarouselArticle> to a JSON string for database storage*/
    @TypeConverter
    fun fromCarouselArticleListToJson(value: List<CarouselArticle>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CarouselArticle>>() {}.type
        return gson.toJson(value, type)
    }

    /*Convert a JSON string from the database to List<CarouselArticle>*/
    @TypeConverter
    fun fromJsonToCarouselArticleList(value: String): List<CarouselArticle> {
        val gson = Gson()
        val type = object : TypeToken<List<CarouselArticle>>() {}.type
        return gson.fromJson(value, type)
    }

    /*Convert List<RecentArticle> to a JSON string for database storage*/
    @TypeConverter
    fun fromRecentArticleListToJson(value: List<RecentArticle>): String {
        val gson = Gson()
        val type = object : TypeToken<List<RecentArticle>>() {}.type
        return gson.toJson(value, type)
    }

    /*Convert a JSON string from the database to List<RecentArticle>*/
    @TypeConverter
    fun fromJsonToRecentArticleList(value: String): List<RecentArticle> {
        val gson = Gson()
        val type = object : TypeToken<List<RecentArticle>>() {}.type
        return gson.fromJson(value, type)
    }
}