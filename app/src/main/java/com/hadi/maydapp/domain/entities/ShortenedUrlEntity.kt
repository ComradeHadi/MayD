package com.hadi.maydapp.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hadi.maydapp.data.models.ShortenedUrlDataModel

@Entity(tableName = "url_table")
data class ShortenedUrlEntity(
    val code: String,
    val short_link: String,
    val full_short_link: String,
    val short_link2: String,
    val full_short_link2: String,
    val short_link3: String,
    val full_short_link3: String,
    val share_link: String,
    val full_share_link: String,
    val original_link: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
){
    companion object{
        fun fromUrlModel(shortenedUrlDataModel: ShortenedUrlDataModel) = ShortenedUrlEntity(
            shortenedUrlDataModel.code,
            shortenedUrlDataModel.short_link,
            shortenedUrlDataModel.full_short_link,
            shortenedUrlDataModel.short_link2,
            shortenedUrlDataModel.full_short_link2,
            shortenedUrlDataModel.short_link3,
            shortenedUrlDataModel.full_short_link3,
            shortenedUrlDataModel.share_link,
            shortenedUrlDataModel.full_share_link,
            shortenedUrlDataModel.original_link
        )
    }

    fun toUrlModel() = ShortenedUrlDataModel(
        code,
        short_link,
        full_short_link,
        short_link2,
        full_short_link2,
        short_link3,
        full_short_link3,
        share_link,
        full_share_link,
        original_link,
        id
    )
}
