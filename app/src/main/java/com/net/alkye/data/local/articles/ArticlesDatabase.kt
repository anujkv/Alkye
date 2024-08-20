package com.net.alkye.data.local.articles

/*
@Database(
    entities = [ArticlesEntity::class,
    CarouselArticle::class,
    SocialConnect::class,
    RecentArticle::class],
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
