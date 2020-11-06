package com.codequest.postsviewer.domain

import io.reactivex.Single

interface UserRepository {
    fun getUsers(): Single<UserResult>
}