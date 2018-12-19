package com.common.dialog

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.common.base.CustomFontTextView
import com.common.base.IBaseAdapter
import com.common.base.ViewHolder
import com.ss.common.views.R

class CommonListItemsDialogAdapter : IBaseAdapter<String> {

    constructor(context: Context, list: List<String>) : super(context, list, R.layout.common_list_items_dialog_adapter)

    override fun getConvertView(convertView: View, list: List<String>, position: Int) {
        val textView = ViewHolder.getView<CustomFontTextView>(convertView , R.id.textView)
        val lineImgView = ViewHolder.getView<ImageView>(convertView , R.id.lineImgView)

        textView.text = list[position]

        lineImgView.visibility = if (position >= count - 1) View.GONE else View.VISIBLE
    }

}