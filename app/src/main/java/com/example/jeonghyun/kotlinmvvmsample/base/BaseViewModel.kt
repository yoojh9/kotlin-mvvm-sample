package com.example.jeonghyun.kotlinmvvmsample.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

// 기본적으로 뷰모델은 android.lifecycle.ViewModel을 상속받으면
open class BaseViewModel : ViewModel() {

    /**
     * RxJava의 Observing을 위한 부분
     * addDisposable을 이용하여 추가하기만 하면 된다
     *  - Model에서 들어오는 Single<>과 같은 RxJava 객체들의 Observing을 위한 부분
     *  - RxJava의 Observable들은 CompositeDisposable에 추가해주고, 뷰모델이 없어질 때 추가했던 것들을 지워줘야 한다.
     *  - Observable들은 옵저빙할 때 addDisposable()을 쓰게 된다
     */
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    // 뷰모델은 view와의 생명주기를 공유하기 때문에 view가 사라질 때 viewModel의 onCleared()가 호출되게 되며 그에 따라 옵저버들이 전부 클리어된다.
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}