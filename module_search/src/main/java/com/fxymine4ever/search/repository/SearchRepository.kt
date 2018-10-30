package com.fxymine4ever.search.repository

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import com.fxymine4ever.common.bean.BeanWrapper
import com.fxymine4ever.common.network.ApiGenerator
import com.fxymine4ever.common.utils.extensions.setSchedulers
import com.fxymine4ever.search.bean.Student
import com.fxymine4ever.search.network.ApiService

class SearchRepository {
    companion object {
        val repository: SearchRepository = SearchRepository()
    }
    private var list: MutableLiveData<BeanWrapper<Student>> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun searchStu(str: String):LiveData<BeanWrapper<Student>>{
        ApiGenerator
                .getApiService(ApiService::class.java)
                .search(str)
                .setSchedulers()
                .subscribe { it->
                    list.value = it
                }
        return list
    }


}