package com.citiasia.inidesakubeta.data.repo

sealed class Resource<out R> private constructor() {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val data: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}
