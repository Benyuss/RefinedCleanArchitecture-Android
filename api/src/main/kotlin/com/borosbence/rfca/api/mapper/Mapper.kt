package com.borosbence.rfca.api.mapper

/**
 * Maps an [E] object to a [T]
 *
 * Child mappers should implement [mapFrom] method.
 * If you want to map a collection, you may use [mapFromList] which depends on the [mapFrom] method.
 */
abstract class Mapper<in E, T> {

    abstract fun mapFrom(from: E): T

    fun mapFromList(from: List<E>): List<T> {
        return from.map { response -> mapFrom(response) }
    }
}