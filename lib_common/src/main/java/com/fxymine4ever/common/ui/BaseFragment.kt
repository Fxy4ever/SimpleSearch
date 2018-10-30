package com.fxymine4ever.common.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxymine4ever.common.event.EmptyEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

open class BaseFragment : Fragment() {


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    //TODO:跳转登陆界面
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun toLoginEvent(event: EmptyEvent){

    }
}