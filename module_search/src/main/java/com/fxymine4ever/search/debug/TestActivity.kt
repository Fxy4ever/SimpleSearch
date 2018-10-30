package com.fxymine4ever.search.debug

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.fxymine4ever.common.ui.BaseActivity
import com.fxymine4ever.common.utils.extensions.gone
import com.fxymine4ever.module_search.R
import com.fxymine4ever.search.ui.SearchFragment
import com.fxymine4ever.search.ui.StuListFragment

class TestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity_test)
        common_toolbar.init("查询",R.drawable.navigation_empty_icon,null)
        initFragment()
    }

    private fun initFragment(){

    }

    //委托back的点击时间给fragment
    override fun onSupportNavigateUp() =
            findNavController(this, R.id.search_container).navigateUp()
}
