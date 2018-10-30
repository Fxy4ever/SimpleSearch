package com.fxymine4ever.common.utils.extensions

import android.content.Context
import android.content.SharedPreferences
import com.fxymine4ever.common.config.DEFAULT_SP_NAME

fun Context.sharedPreferences(name:String) :SharedPreferences =
        getSharedPreferences(name, Context.MODE_PRIVATE)

val Context.defaultSharedPrefernces get() = sharedPreferences(name = DEFAULT_SP_NAME)

fun SharedPreferences.eiditor(editorBuilder: SharedPreferences.Editor.() -> Unit) = edit().apply(editorBuilder).apply()