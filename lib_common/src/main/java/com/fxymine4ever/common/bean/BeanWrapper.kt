package com.fxymine4ever.common.bean

data class BeanWrapper<T>(

        val code: Int,
        val info: String,
        val results: MutableList<T>
)