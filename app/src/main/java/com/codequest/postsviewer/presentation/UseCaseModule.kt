package com.codequest.postsviewer.presentation

import com.codequest.postsviewer.domain.UserUseCase
import com.codequest.postsviewer.domain.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindUserUseCase(impl: UserUseCaseImpl): UserUseCase
}