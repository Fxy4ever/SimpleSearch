package com.fxymine4ever.search.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.fxymine4ever.common.bean.BeanWrapper
import com.fxymine4ever.search.bean.Student
import com.fxymine4ever.search.repository.SearchRepository

open class SearchModel(application: Application) : AndroidViewModel(application) {
    var stuList: LiveData<BeanWrapper<Student>>

    init {
        stuList = SearchRepository.repository.searchStu("")
    }

    fun searchStu(str: String){
       stuList = SearchRepository.repository.searchStu(str)
    }

    override fun onCleared() {
        super.onCleared()
    }
}