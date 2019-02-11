package com.fxymine4ever.main.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import androidx.navigation.Navigation
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.fxymine4ever.common.ui.BaseActivity
import com.fxymine4ever.module_main.R
import kotlinx.android.synthetic.main.main_activity_container.*
import org.jetbrains.anko.toast

@Route(path = "/main/ContainerActivity")
class ContainerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_container)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        common_toolbar.init("简单查询",R.drawable.navigation_empty_icon,null)
        ARouter.getInstance().build("/search/SearchConFragment").navigation()?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,it as Fragment)
            transaction.commit()
        }

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_search -> {
                toast("已经是查询界面了")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    //委托back的点击时间给fragment
    override fun onSupportNavigateUp() =
            Navigation.findNavController(this, R.id.search_container).navigateUp()
}
