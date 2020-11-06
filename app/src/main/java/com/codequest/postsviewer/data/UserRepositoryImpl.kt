package com.codequest.postsviewer.data

import com.codequest.postsviewer.domain.UserRepository
import com.codequest.postsviewer.domain.UserResult
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserRepository {

    override fun getUsers(): Single<UserResult> {
        return userApiService.getUsers()
    }
}