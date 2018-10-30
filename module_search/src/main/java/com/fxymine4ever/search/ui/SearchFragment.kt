package com.fxymine4ever.search.ui

import android.os.Bundle
import android.view.*
import androidx.navigation.Navigation
import com.alibaba.android.arouter.facade.annotation.Route
import com.fxymine4ever.common.ui.BaseFragment
import com.fxymine4ever.module_search.R
import kotlinx.android.synthetic.main.search_fragment_input.view.*
import org.jetbrains.anko.sdk25.coroutines.onTouch
import org.jetbrains.anko.support.v4.defaultSharedPreferences
import org.jetbrains.anko.support.v4.toast

@Route(path = "/search/SearchFragment")
class SearchFragment : BaseFragment() {
    private lateinit var parent: View

    companion object {
        var str = ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.search_fragment_input, container, false)
        init()
        return parent
    }

    private fun init() {
        parent.et_search_commit.setOnClickListener {
            str = parent.et_search_input.text.toString()
            if (str.isNotBlank() && str.isNotEmpty()) {
                Navigation.findNavController(it).navigate(R.id.action_toList)
            }else{
                toast("请进行正确的输入.")
            }
        }
    }
}