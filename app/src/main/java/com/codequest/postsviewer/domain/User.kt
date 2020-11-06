package com.codequest.postsviewer.domain

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: Username,

    @SerializedName("picture")
    val picture: UserPicture
)