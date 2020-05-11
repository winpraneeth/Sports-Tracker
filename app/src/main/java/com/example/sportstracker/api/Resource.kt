package com.example.sportstracker.api

class Resource<T> private constructor(
    val status: Status,
    val data: T?,
    val message: String?
) {

    companion object {
        @JvmStatic
        fun <T> success(data: T): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        @JvmStatic
        fun <T> error(msg: String?, data: T?): Resource<T?> {
            return Resource(
                Status.ERROR,
                data,
                msg
            )
        }

        @JvmStatic
        fun <T> loading(data: T?): Resource<T?> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }
    }

}