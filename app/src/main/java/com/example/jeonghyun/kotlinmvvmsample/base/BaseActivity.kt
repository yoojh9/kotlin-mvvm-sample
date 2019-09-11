package com.example.jeonghyun.kotlinmvvmsample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * BaseActivity<ActivityMainBinding> 와 같이 상속받을 때 ActivityMainBiding이 자동생성도지 않는다면
 *  1. 해당 액티비티의 레이아웃이 <layout></layout>으로 감싸져 있는지 확인
 *  2. 다시 빌드 수행 or 클린 빌드 후 다시 빌드 수행
 *  3. 이름 확인 : activity_main -> ActivityMainBiding
 */
abstract class BaseActivity<T: ViewDataBinding, R: BaseViewModel> : AppCompatActivity() {

    lateinit var viewDataBinding: T

    /**
     * setContectView로 호출할 Layout의 리소스 Id
     */
    abstract val layoutResourceId: Int

    /**
     * viewModel로 쓰일 변수
     */
    abstract val viewModel: R

    /**
     * 레이아웃을 띄운 직후 호출.
     * 뷰나 엑티비티 속성 등을 초기화.
     *  ex) 리사이클러뷰, 툴바, 드로어뷰
     */
    abstract fun initStartView()

    /**
     * 두번째로 호출
     * 데이터 바인딩 및 RxJava 설정
     *  ex) rxjava observe, databinding observe
     */
    abstract fun initDataBinding()

    /**
     * 바인딩 이후에 할 일을 구현
     * 그 외에 설정할 것이 있으면 이곳에서 설정
     * 클릭 리스너도 이곳에서 설정
     */
    abstract fun initAfterBinding()

    private var isSetBackButtonValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)

        initStartView()
        initDataBinding()
        initAfterBinding()
    }
}