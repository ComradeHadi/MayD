package com.hadi.maydapp.data.repository

import com.hadi.maydapp.data.datasource.remotedatasource.ServiceApi
import com.hadi.maydapp.data.mappers.DataLayerLinksesMapper
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.data.models.ShortenedUrlResponse
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import com.hadi.maydapp.presentation.models.LinkUIModel
import io.reactivex.Single

class StubServiceApi : ServiceApi {
    private val dataLayerLinksMapper = DataLayerLinksesMapper()

    private var response: ShortenedUrlResponse =
        ShortenedUrlResponse(
            ok = true,
            result = ShortenedUrlDataModel(
                code = "DrpLId",
                short_link = "shrtco.de/DrpLId",
                full_short_link = "https://shrtco.de/DrpLId",
                short_link2 = "9qr.de/DrpLId",
                full_short_link2 = "https:9qr.de/DrpLId",
                short_link3 = "shiny.link/DrpLId",
                full_short_link3 = "shiny.link/DrpLId",
                share_link = "shiny.link/DrpLId",
                full_share_link = "shiny.link/DrpLId",
                original_link = "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s",
            )
        )
    private  var fakeLinkDomainEntity : ShortenedUrlEntity
    private  var fakeLinkDataModel: ShortenedUrlDataModel
    private  var fakeLinkUIModel: LinkUIModel


    init{

        fakeLinkDomainEntity = ShortenedUrlEntity(
            code = "DrpLId",
            short_link = "shrtco.de/DrpLId",
            full_short_link = "https://shrtco.de/DrpLId",
            short_link2 = "9qr.de/DrpLId",
            full_short_link2 = "https:9qr.de/DrpLId",
            short_link3 = "shiny.link/DrpLId",
            full_short_link3 = "shiny.link/DrpLId",
            share_link = "shiny.link/DrpLId",
            full_share_link = "shiny.link/DrpLId",
            original_link = "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s",
        )

        fakeLinkDataModel = ShortenedUrlDataModel(
            code = "DrpLId",
            short_link = "shrtco.de/DrpLId",
            full_short_link = "https://shrtco.de/DrpLId",
            short_link2 = "9qr.de/DrpLId",
            full_short_link2 = "https:9qr.de/DrpLId",
            short_link3 = "shiny.link/DrpLId",
            full_short_link3 = "shiny.link/DrpLId",
            share_link = "shiny.link/DrpLId",
            full_share_link = "shiny.link/DrpLId",
            original_link = "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s",
        )

        fakeLinkUIModel = LinkUIModel(
            code = "DrpLId",
            short_link = "shrtco.de/DrpLId",
            full_short_link = "https://shrtco.de/DrpLId",
            short_link2 = "9qr.de/DrpLId",
            full_short_link2 = "https:9qr.de/DrpLId",
            short_link3 = "shiny.link/DrpLId",
            full_short_link3 = "shiny.link/DrpLId",
            share_link = "shiny.link/DrpLId",
            full_share_link = "shiny.link/DrpLId",
            original_link = "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s",
        )

    }


    private fun getLinkByCode(code: String) : LinkUIModel {
        return LinkUIModel(
            code = code,
            short_link = "shrtco.de/DrpLId",
            full_short_link = "https://shrtco.de/DrpLId",
            short_link2 = "9qr.de/DrpLId",
            full_short_link2 = "https:9qr.de/DrpLId",
            short_link3 = "shiny.link/DrpLId",
            full_short_link3 = "shiny.link/DrpLId",
            share_link = "shiny.link/DrpLId",
            full_share_link = "shiny.link/DrpLId",
            original_link = "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s",
        )

    }


    fun getDomainUrlEntity() : ShortenedUrlEntity{
        return fakeLinkDomainEntity
    }

    fun getRepoModel() : ShortenedUrlDataModel{
        return fakeLinkDataModel
    }

    fun getLinkModelUI() : LinkUIModel{
        return fakeLinkUIModel
    }

    override fun getShortenedUrlFromServer(url: String): Single<ShortenedUrlResponse> {
        return Single.just(response)
    }


}

