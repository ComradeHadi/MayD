package com.hadi.maydapp.presentation.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity

@Database(entities = [ShortenedUrlEntity::class], version = 1)
abstract class DatabseService : RoomDatabase(){

    companion object {
        private const val DATABASE_NAME = "mayd_url.db"
        private var instance: DatabseService ? = null

        private fun create(context: Context) : DatabseService =
            Room.databaseBuilder(context, DatabseService::class.java, DATABASE_NAME )
                .fallbackToDestructiveMigration()
                .build()

         fun getInstance(context: Context) : DatabseService =
            (instance ?: create(context)).also{ instance = it}
    }

    abstract fun urlDao(): UrlDao
}