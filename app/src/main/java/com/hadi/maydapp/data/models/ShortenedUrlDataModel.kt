package com.hadi.maydapp.data.models

import com.google.gson.annotations.SerializedName
import com.hadi.maydapp.presentation.models.LinkUIModel

data class ShortenedUrlDataModel(
    @SerializedName("code")
    val code: String,

    @SerializedName("short_link")
    val short_link: String,

    @SerializedName("full_short_link")
    val full_short_link: String,

    @SerializedName("short_link2")
    val short_link2: String,

    @SerializedName("full_short_link2")
    val full_short_link2: String,

    @SerializedName("short_link3")
    val short_link3: String,

    @SerializedName("full_short_link3")
    val full_short_link3: String,

    @SerializedName("share_link")
    val share_link: String,

    @SerializedName("full_share_link")
    val full_share_link: String,

    @SerializedName("original_link")
    val original_link: String,

    var id: Long = 0L,

    )
{
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
}
