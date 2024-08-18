package com.net.alkye.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.net.alkye.utils.Converters

/*
@Database(
    entities = [ArticlesEntity::class, CarouselArticle::class, RecentArticle::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class ArticlesDatabase : RoomDatabase(){
    abstract fun articlesDao(): ArticlesDao

    companion object {
        @Volatile
        private var INSTANCE: ArticlesDatabase? = null

        fun getDatabase(context: Context): ArticlesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticlesDatabase::class.java,
                    "articles_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}*/
