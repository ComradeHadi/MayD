package com.hadi.maydapp.presentation.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity

@Dao
interface UrlDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertUrl (url: ShortenedUrlEntity)

    @Query("SELECT * FROM url_table WHERE id= :id")
    suspend fun getUrl (id: Long): ShortenedUrlEntity?


    @Query("SELECT * FROM url_table")
    suspend fun getAllUrl (): List<ShortenedUrlEntity>
}