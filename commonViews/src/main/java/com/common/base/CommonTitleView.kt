package com.common.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.common.util.Utils
import com.ss.common.views.R
import kotlinx.android.synthetic.main.common_title_view.view.*

class CommonTitleView : BaseKotlinRelativeLayout {

    var onCommonTitleItemClickListener : OnCommonTitleClickListener?= null

    constructor(context: Context) : super(context){
        init()
    }

    constructor(context: Context , attrs : AttributeSet) : super(context , attrs){
        init()
    }

    override fun initViews() {
        View.inflate(context , R.layout.common_title_view , this)

        val statusBarHeight = Utils.getStatusBarHeight(context)
        if (statusBarHeight != 0){
            val layoutParams = topTextView.layoutParams
            layoutParams.height = statusBarHeight
            topTextView.layoutParams = layoutParams
        }

    }

    override fun initListener() {
        commonLeftTextView.setOnClickListener {
            onCommonTitleItemClickListener?.onLeftBtnClick()
        }
        commonRightTextView.setOnClickListener {
            onCommonTitleItemClickListener?.onRightBtnClick()
    }
    }

    fun setTitleBackgroundColor(color : Int){
        topTextView.setBackgroundColor(color)
        titleLayout.setBackgroundColor(color)
    }

    fun setLeftBtnText(leftBtnText : String){
        commonLeftTextView.text = leftBtnText
    }

    fun setLeftBtnTextColor(leftBtnColor : Int){
        commonLeftTextView.setTextColor(leftBtnColor)
    }

    fun setRightBtnText(rightBtnText : String){
        commonRightTextView.text = rightBtnText
    }

    fun setRightBtnTextColor(rightBtnColor : Int){
        commonRightTextView.setTextColor(rightBtnColor)
    }

    fun setCenterTitle(centerTitle : String){
        centerTitleTextView.text = centerTitle
    }

    fun setLeftBtnBackground(drawable : Int){
        ViewHelper.setLeftCompoundDrawables(context , commonLeftTextView , drawable)
    }

    fun setRightBtnBackground(drawable : Int){
        ViewHelper.setRightCompoundDrawables(context , commonRightTextView , drawable)
    }

    fun setLeftBtnVisibility(visibility : Int){
        commonLeftTextView.visibility = visibility
    }

    fun setRightBtnVisibility(visibility : Int){
        commonRightTextView.visibility = visibility
    }

    fun setLeftBtnEnabled(enabled : Boolean){
        commonLeftTextView.isEnabled = enabled
    }

    fun setRightBtnEnabled(enabled : Boolean){
        commonRightTextView.isEnabled = enabled
    }

}