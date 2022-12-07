package com.hadi.maydapp.presentation.mapper

interface DomainToPresentationMapper<R, E> {

    fun mapDomainToPresentationModel(model : R) : E
}
