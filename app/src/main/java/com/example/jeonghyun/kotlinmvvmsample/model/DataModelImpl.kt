package com.example.jeonghyun.kotlinmvvmsample.model

import com.example.jeonghyun.kotlinmvvmsample.model.enum.KakaoSearchSortEnum
import com.example.jeonghyun.kotlinmvvmsample.model.response.ImageSearchResponse
import com.example.jeonghyun.kotlinmvvmsample.model.service.KakaoSearchService
import io.reactivex.Single

class DataModelImpl(private val service:KakaoSearchService) : DataModel {

    private val KAKAO_APP_KEY = "1838e3482a490abc701020b0e50a17fa"

    override fun getData(query: String, sort:KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse> {
        return service.searchImage(auth="KakaoAK $KAKAO_APP_KEY", query=query, sort=sort.sort, page=page, size=size)
    }

}