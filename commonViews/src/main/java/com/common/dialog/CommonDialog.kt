package com.common.dialog

import android.content.Context
import android.os.Bundle
import com.ss.common.views.R
import kotlinx.android.synthetic.main.common_dialog.*

class CommonDialog : BaseKotlinDialog {

    var onCommonItemClickListener : OnCommonItemClickListener<Int> ?= null

    constructor(context: Context) : super(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_dialog)

        init()
    }

    override fun initListeners() {
        leftBtnTextView.setOnClickListener {
            dismiss()
            onCommonItemClickListener?.onItemClick(0)
        }
        rightBtnTextView.setOnClickListener {
            dismiss()
            onCommonItemClickListener?.onItemClick(1)
        }
    }


    fun setParams(content : String , leftBtnText : String , rightBtnText : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?){
        contentTextView.text = content
        leftBtnTextView.text = leftBtnText
        rightBtnTextView.text = rightBtnText
        this.onCommonItemClickListener = onCommonItemClickListener
    }

    fun setContentGravity(gravity : Int){
        contentTextView.gravity = gravity
    }

}