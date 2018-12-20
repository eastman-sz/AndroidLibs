package com.ss.lib.views

import android.content.Context
import android.view.View
import com.common.base.CustomFontTextView
import com.common.base.ViewHolder
import com.ss.lib.R
import com.wheelview.adapter.BaseWheelAdapter

class TextWheelAdapter : BaseWheelAdapter<String>{

    constructor(context: Context , list: List<String> ) : super(context, list, R.layout.text_wheel_adapter){

    }

    override fun getConvertView(convertView: View, list: List<String>, position: Int) {
        val textView = ViewHolder.getView<CustomFontTextView>(convertView , R.id.textView)

        val text = list[position]

        textView.text = text
    }

}