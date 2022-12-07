package com.hadi.maydapp.data.localmodels

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface LocalModelsDAO {

    @Insert(onConflict = REPLACE)
    suspend fun saveUrl(shortenedUrlDBModel: ShortenedUrlDBModel)

    @Query("SELECT * FROM urls")
    suspend fun getAllLocalUrls(): List<ShortenedUrlDBModel>
}