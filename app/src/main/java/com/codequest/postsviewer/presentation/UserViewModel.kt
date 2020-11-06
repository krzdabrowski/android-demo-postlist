package com.codequest.postsviewer.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codequest.postsviewer.domain.User
import com.codequest.postsviewer.domain.UserResult
import com.codequest.postsviewer.domain.UserUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class UserViewModel @ViewModelInject constructor(
    private val userUseCase: UserUseCase,
    @MainScheduler private val mainScheduler: Scheduler,
    @IoScheduler private val ioScheduler: Scheduler
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>> = _userLiveData

    init {
        fetchData()
    }

    private fun fetchData() {
        userUseCase()
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribeBy(
                { Log.e("TAG", "error: ${it.localizedMessage}") },
                { _userLiveData.value = it }
            )
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}