package com.fxymine4ever.search.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup

class MFragmentPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    lateinit var fragments:MutableList<Fragment>
    lateinit var titles:MutableList<String>

    constructor(fm: FragmentManager?,
                list:MutableList<String>,
                list1:MutableList<Fragment>): this(fm){
        this.fragments = list1
        this.titles = list
    }

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeViewAt(position)
    }

    override fun getPageTitle(position: Int) = titles[position]

}