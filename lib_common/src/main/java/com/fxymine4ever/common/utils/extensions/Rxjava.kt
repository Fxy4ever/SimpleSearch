package com.fxymine4ever.common.utils.extensions

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.setSchedulers(
        subscribeOn: Scheduler = Schedulers.io(),
        unsubscribeOn: Scheduler = Schedulers.io(),
        observeOn: Scheduler = AndroidSchedulers.mainThread()
): Observable<T> = subscribeOn(subscribeOn).unsubscribeOn(unsubscribeOn).observeOn(observeOn)

