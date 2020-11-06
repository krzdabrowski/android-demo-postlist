package com.codequest.postsviewer.data

import com.codequest.postsviewer.domain.UserResult
import io.reactivex.Single
import retrofit2.http.GET

interface UserApiService {

    @GET("api")
    fun getUsers(): Single<UserResult>
}