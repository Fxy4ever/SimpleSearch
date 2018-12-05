package com.fxymine4ever.search.ui.adapter

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fxymine4ever.module_search.R
import com.fxymine4ever.search.bean.Student
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
                        val dialog = Dialog(mContext, R.style.edit_AlertDialog_style)
                        dialog.setContentView(R.layout.search_show_img_dialog)
                        val imageView = dialog.findViewById<ImageView>(R.id.show_img)
                        Glide.with(mContext)
                                .load("https://fxy.red/photos/"+stu.stuNum+".jpg")
                                .into(imageView)
                        dialog.setCanceledOnTouchOutside(true)
                        val defaultDisplay = (mContext as Activity).windowManager.defaultDisplay
                        val dialogWindow = dialog.window
                        val lp = dialogWindow!!.attributes
                        lp.height = (defaultDisplay.height * 0.5).toInt()
                        lp.width = (defaultDisplay.width * 0.6).toInt()
                        dialogWindow.attributes = lp
                        dialog.show()
                    }
                }

            }
        }
    }
}