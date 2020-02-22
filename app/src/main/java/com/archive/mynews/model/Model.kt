package com.archive.mynews.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Date,
    val content: String
)

data class Source(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: Category,
    val language: String,
    val country: String
)

// TODO: enum 으로 할 필요 없는가?
enum class CountryCode(val code: String) {
    UNITED_STATE("us"),
    JAPAN("jp"),
    REPUBLIC_OF_KOREA("kr"),
}

enum class Category {
    @SerializedName("business")
    BUSINESS,
    @SerializedName("entertainment")
    ENTERTAINMENT,
    @SerializedName("general")
    GENERAL,
    @SerializedName("health")
    HEALTH,
    @SerializedName("science")
    SCIENCE,
    @SerializedName("sports")
    SPORTS,
    @SerializedName("technology")
    TECHNOLOGY,
    ;

    fun toLowerCase(): String {
        return this.name.toLowerCase()
    }
}