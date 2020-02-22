package com.archive.mynews.api

import com.archive.mynews.model.Article
import com.archive.mynews.model.Source
import com.google.gson.annotations.SerializedName

enum class Status {
    @SerializedName("ok")
    OK,
    @SerializedName("error")
    ERROR,
}

data class NewsResponse(
    val status: Status,
    val totalResults: Int,
    val articles: List<Article>
)

data class SourceResponse(
    val status: Status,
    val sources: List<Source>
)

data class NewsError(
    val status: Status,
    val code: String?,
    val message: String?
)