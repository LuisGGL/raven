package com.raven.home.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raven.home.data.local.dao.NewsDao
import com.raven.home.data.local.model.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDataBase: RoomDatabase() {
    abstract val dao: NewsDao
}