package com.ss.lib.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.common.base.BaseKotlinRelativeLayout
import com.common.dialog.OnCommonItemClickListener
import com.ss.lib.R
import com.wheelview.HorizontalWheelView
import com.wheelview.OnWheelChangedListener
import kotlinx.android.synthetic.main.text_wheel_view.view.*

class TextWheelView : BaseKotlinRelativeLayout {

    var onCommonItemClickListener : OnCommonItemClickListener<String> ?= null

    constructor(context: Context) : super(context) {init()}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {init()}

    override fun initViews() {
        View.inflate(context , R.layout.text_wheel_view , this)

        initData()
    }

    private fun initData(){
        val list = ArrayList<String>()
        list.add("A")
        list.add("B")
        list.add("C")
        list.add("D")
        list.add("E")
        list.add("F")
        list.add("G")
        list.add("H")
        list.add("I")
        list.add("J")

        val adapter = TextWheelAdapter(context, list)
        wheelView.viewAdapter = adapter
        wheelView.visibleItems = 5
        wheelView.currentItem = 3

        wheelView.addChangingListener(object : OnWheelChangedListener{
            override fun onChanged(p0: HorizontalWheelView, oldValue: Int, newValue: Int) {
                onCommonItemClickListener?.onItemClick(list[newValue])
            }
        })

        postDelayed({
            onCommonItemClickListener?.onItemClick(list[wheelView.currentItem])
        } , 500)
    }


}