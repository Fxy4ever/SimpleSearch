package com.fxymine4ever.search.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.alibaba.android.arouter.facade.annotation.Route
import com.fxymine4ever.common.bean.BeanWrapper
import com.fxymine4ever.common.ui.BaseFragment
import com.fxymine4ever.common.utils.extensions.gone
import com.fxymine4ever.common.utils.extensions.visible
import com.fxymine4ever.module_search.R
import com.fxymine4ever.search.bean.Student
import com.fxymine4ever.search.model.SearchModel
import com.fxymine4ever.search.ui.adapter.QueryStuAdapter
import kotlinx.android.synthetic.main.search_fragment_list.*
import kotlinx.android.synthetic.main.search_fragment_list.view.*
import org.jetbrains.anko.support.v4.toast

@Route(path = "/search/StuListFragment")
class StuListFragment : BaseFragment() {
    private lateinit var model: SearchModel
    private var list: MutableList<Student> = mutableListOf()
    private val layouts = intArrayOf(R.layout.search_recycler_item_stu)
    private lateinit var adapter: QueryStuAdapter
    private lateinit var parent: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.search_fragment_list, container, false)
        initRv()
        return parent
    }

    private fun initRv() {
        context?.let { it ->
            adapter = QueryStuAdapter(it, list, layouts)
            parent.rv_search.adapter = adapter
            parent.rv_search.apply {

                layoutManager = LinearLayoutManager(it)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        parent.et_search_back.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
            parent.pb_search.visible()
            parent.tv_notFound.gone()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model = ViewModelProviders.of(this).get(SearchModel::class.java)
        model.searchStu(SearchFragment.str)
        observer(model.stuList)
    }

    private fun observer(list: LiveData<BeanWrapper<Student>>): Unit {
        list.observeForever { it ->
            it?.let {
                if (it.results != null) {
                    parent.pb_search.gone()
                    if(it.code==200) {
                        adapter.refreshData(it.results)
                    }
                    else {
                        toast(it.info)
                        parent.tv_notFound.visible()
                    }

                }
            }
        }
    }
}