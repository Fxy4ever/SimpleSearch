package com.fxymine4ever.search.network

import com.fxymine4ever.common.bean.BeanWrapper
import com.fxymine4ever.search.bean.Student
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/cqupt/query")
    fun search(@Query("search") str:String): Observable<BeanWrapper<Student>>
}