package com.hadi.maydapp.data.mappers

import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity

class DataLayerLinksesMapper : DataToDomainMapper<ShortenedUrlDataModel, ShortenedUrlEntity>{
    override fun mapDataToDomainModel(model: ShortenedUrlDataModel): ShortenedUrlEntity {
        return ShortenedUrlEntity(
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
