package com.codequest.postsviewer.domain

import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserUseCase {

    override fun invoke(): Single<List<User>> {
        return Observable
            .fromIterable(0..9)
            .delay(200, TimeUnit.MILLISECONDS)
            .flatMap { userRepository.getUsers().toObservable() }
            .map { it.results.first() }
            .toList()
    }
}