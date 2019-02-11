package com.fxymine4ever.search.ui.adapter

import android.content.Context
import com.fxymine4ever.search.bean.Student
import com.fxymine4ever.search.ui.pop.ShowPhotoPop
import com.fxymine4ever.search.utils.baseRv.BaseHolder
import com.fxymine4ever.search.utils.baseRv.FBaseAdapter
import kotlinx.android.synthetic.main.search_recycler_item_stu.view.*

class QueryStuAdapter(val mContext: Context,
                   mData: MutableList<Student>?,
                   mLayoutIds: IntArray) :
        FBaseAdapter<Student>(mContext, mData, mLayoutIds) {

    override fun getItemType(position: Int): Int {
        getData()?.let { it->
            return if (position != it.size) NORMAL else FOOTER
        }
        return FOOTER
    }

    override fun onBinds(holder: BaseHolder, t: MutableList<Student>?, position: Int, viewType: Int) {
        when(viewType){
            NORMAL ->{
                val parent = holder.itemView
                t?.let {
                    val stu = t[position]
                    parent.tv_stuName.text = stu.name
                    parent.tv_stuNum.text = stu.stuNum
                    parent.tv_sex.text = stu.sex
                    parent.tv_classNum.text = stu.classNum
                    parent.tv_major.text = stu.major
                    parent.tv_academy.text = stu.academy
                    parent.setOnClickListener {
                        val pop = ShowPhotoPop(mContext,"https://fxy.red/photos/"+stu.stuNum+".jpg")
                        pop.showPopupWindow()
                    }
                }

            }
        }
    }
}