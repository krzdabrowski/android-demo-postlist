package com.codequest.postsviewer.presentation

import com.codequest.postsviewer.data.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

private const val BASE_URL = "https://randomuser.me/"

@Qualifier
annotation class MainScheduler

@Qualifier
annotation class IoScheduler

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @MainScheduler
    @Singleton
    @Provides
    fun provideMainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @IoScheduler
    @Singleton
    @Provides
    fun provideIoScheduler(): Scheduler {
        return Schedulers.io()
    }
}