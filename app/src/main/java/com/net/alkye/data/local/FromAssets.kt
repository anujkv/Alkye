package com.net.alkye.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.net.alkye.data.local.articles.ArticlesEntity
import com.net.alkye.data.local.config.ConfigMenu

fun loadArticlesFromAssets(context: Context): ArticlesEntity {
    val jsonString = context
        .assets
        .open(
        "articles.json")
            .bufferedReader()
            .use {
                it.readText()
            }
    val type = object : TypeToken<ArticlesEntity>(){}.type
    return Gson().fromJson(jsonString, type)

}

fun loadConfigFromAssets(context: Context): ConfigMenu {
    val jsonString = context
        .assets
        .open(
            "config.json")
        .bufferedReader()
        .use { it.readText() }
    val type = object : TypeToken<ConfigMenu>(){}.type
    return Gson().fromJson(jsonString, type)
}