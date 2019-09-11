package com.example.jeonghyun.kotlinmvvmsample.di

import com.example.jeonghyun.kotlinmvvmsample.model.DataModel
import com.example.jeonghyun.kotlinmvvmsample.model.DataModelImpl
import com.example.jeonghyun.kotlinmvvmsample.model.service.KakaoSearchService
import com.example.jeonghyun.kotlinmvvmsample.view.MainSearchRecyclerViewAdapter
import com.example.jeonghyun.kotlinmvvmsample.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 의존성 주입에 사용할 모듈. 의존성 주입을 하는 실제 코드
 */
var modelPart =  module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

// 뷰모델을 만듦. 액티비티에서 by viewModel()을 통해서 얻어올 수 있음
var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var adapterPart = module {
    factory {
        MainSearchRecyclerViewAdapter()
    }
}

var retrofitPart = module {
    single<KakaoSearchService> {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KakaoSearchService::class.java)
    }
}

var DiModule = listOf(modelPart, viewModelPart, retrofitPart, adapterPart)