package com.raven.home.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raven.home.data.local.model.NewsEntity

@Dao
interface NewsDao {
    @Query("SELECT * from news_table")
    fun getAll(): List<NewsEntity>

    @Query("DELETE FROM news_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(news: List<NewsEntity>)

}