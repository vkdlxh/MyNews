package com.archive.mynews.model

import com.google.gson.annotations.SerializedName

enum class Category {
    @SerializedName("general")
    GENERAL,

    ;

    fun toLowerCase(): String {
        return this.name.toLowerCase()
    }
}