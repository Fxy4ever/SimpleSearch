package com.fxymine4ever.search.ui.pop

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import com.bumptech.glide.Glide
import com.fxymine4ever.module_search.R
import razerdp.basepopup.BasePopupWindow

/**
 * create by:Fxymine4ever
 * time: 2019/2/11
 */
class ShowPhotoPop (context: Context?) :
        BasePopupWindow(context) {
    private lateinit var mUrl: String
    private lateinit var mContext: Context
    constructor(context: Context?,url:String):this(context){
        this.mUrl = url
        context?.let {
            this.mContext = it
        }
        init()
    }

    private fun init(){
        setClipChildren(false)
        popupGravity = Gravity.CENTER
        Glide.with(mContext).load(mUrl).into(findViewById(R.id.iv_show_stu))
    }
    override fun onCreateContentView(): View {
        val view = createPopupById(R.layout.search_show_dialog)
        view.setOnClickListener {
            dismiss()
        }
        return view
    }

    override fun onCreateShowAnimation(): Animation  = getDefaultScaleAnimation(true)

    override fun onCreateDismissAnimation(): Animation = getDefaultScaleAnimation(false)
}