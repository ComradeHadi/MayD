package com.hadi.maydapp.data.mappers

interface DataToDomainMapper<R, E> {

    fun mapDataToDomainModel(model : R) : E
}
