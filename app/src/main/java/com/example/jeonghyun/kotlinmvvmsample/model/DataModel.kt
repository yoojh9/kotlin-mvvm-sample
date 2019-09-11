package com.example.jeonghyun.kotlinmvvmsample.model

import com.example.jeonghyun.kotlinmvvmsample.model.enum.KakaoSearchSortEnum
import com.example.jeonghyun.kotlinmvvmsample.model.response.ImageSearchResponse
import io.reactivex.Single

interface DataModel {
    fun getData(query: String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse>
}