package com.codequest.postsviewer.domain

import com.google.gson.annotations.SerializedName

data class UserResult(
    @SerializedName("results")
    val results: List<User>
)