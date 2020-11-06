package com.codequest.postsviewer.domain

import com.google.gson.annotations.SerializedName

data class UserPicture(
    @SerializedName("medium")
    val userPictureUrl: String
)