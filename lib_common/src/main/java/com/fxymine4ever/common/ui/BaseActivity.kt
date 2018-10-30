package com.fxymine4ever.common.ui

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.WindowManager
import com.fxymine4ever.common.R
import com.fxymine4ever.common.event.EmptyEvent
import kotlinx.android.synthetic.main.common_toolbar.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.startActivity

abstract class BaseActivity : AppCompatActivity() {
    companion object {
        val TAG: String = BaseActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    }

    inline fun <reified T : Activity> startActivity(finish: Boolean = false
                                                    , vararg params: Pair<String, Any?>) {
        if (finish) finish()
        startActivity<T>(*params)
    }

    protected fun Toolbar.init(title: String,
                               @DrawableRes icon: Int = R.drawable.common_ic_back,
                               listener: View.OnClickListener? = View.OnClickListener { finish() }) {
        this.title = title
        setSupportActionBar(this)
        if (listener == null)
            navigationIcon = null
        else {
            setNavigationIcon(icon)
            setNavigationOnClickListener(listener)
        }
    }

    protected val BaseActivity.common_toolbar get() = toolbar

//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        EventBus.getDefault().unregister(this)
//    }
//
//    //TODO:跳转登陆界面
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    open fun toLoginEvent(event: EmptyEvent){
//
//    }
}