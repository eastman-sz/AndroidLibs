package com.common.dialog

import android.content.Context
import android.os.Bundle
import com.ss.common.views.R
import kotlinx.android.synthetic.main.common_single_btn_dialog.*
/**
 * Dialog with single button.
 * @author E
 */
class CommonSingleBtnDialog : BaseKotlinDialog {

    var onCommonItemClickListener : OnCommonItemClickListener<Int> ?= null

    constructor(context: Context) : super(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_single_btn_dialog)

        init()
    }

    override fun initListeners() {
        btnTextView.setOnClickListener {
            dismiss()
            onCommonItemClickListener?.onItemClick(0)
        }
    }

    fun setParams(content : String , btnText : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?){
        contentTextView.text = content
        btnTextView.text = btnText
        this.onCommonItemClickListener = onCommonItemClickListener
    }

}