package com.archive.mynews.api

interface Result<T> {
    fun onSuccess(response: T)

    fun onFailure(error: NewsError)
}