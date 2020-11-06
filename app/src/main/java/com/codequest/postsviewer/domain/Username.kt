package com.codequest.postsviewer.domain

import com.google.gson.annotations.SerializedName

data class Username(
    @SerializedName("first")
    val firstName: String,

    @SerializedName("last")
    val lastName: String
)