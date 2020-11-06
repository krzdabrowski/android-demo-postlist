package com.codequest.postsviewer.domain

import io.reactivex.Single

interface UserUseCase {
    operator fun invoke(): Single<List<User>>
}