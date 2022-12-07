package com.hadi.maydapp.presentation.mapper

import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import com.hadi.maydapp.presentation.models.LinkUIModel

class LinkMapper : DomainToPresentationMapper<ShortenedUrlEntity, LinkUIModel> {
    override fun mapDomainToPresentationModel(model: ShortenedUrlEntity): LinkUIModel {
        return LinkUIModel(
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
