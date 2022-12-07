package com.hadi.maydapp.data.localmodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.presentation.models.LinkUIModel
import com.hadi.maydapp.presentation.models.db.ShortenedUrlDbModel

@Entity(tableName = "urls")
data class ShortenedUrlDBModel(

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
    var id: Long = 0L,

    ){

    fun toLinkUIModel() = LinkUIModel(
        code,
        short_link,
        full_short_link,
        full_short_link,
        full_short_link2,
        short_link3,
        short_link3,
        share_link,
        share_link,
        original_link
    )

    fun toRemoteUrlModel() = ShortenedUrlDataModel(
        code,
        short_link,
        full_short_link,
        full_short_link,
        full_short_link2,
        short_link3,
        short_link3,
        share_link,
        share_link,
        original_link
    )

    companion object {
        fun fromRemoteUrlModel(model: ShortenedUrlDataModel) = ShortenedUrlDBModel(
            code = model.code,
            short_link = model.short_link,
            full_short_link = model.full_short_link,
            short_link2 = model.full_short_link,
            full_short_link2 = model.full_short_link2,
            short_link3 = model.short_link3,
            full_short_link3 = model.short_link3,
            share_link = model.share_link,
            full_share_link = model.share_link,
            original_link = model.original_link
        )

    }
}
