package com.common.dialog

import android.content.Context
import android.os.Bundle
import com.ss.common.views.R
import kotlinx.android.synthetic.main.common_list_items_dialog.*
import java.util.ArrayList
/**
 * 带Title栏的列表上滑弹出窗口。
 * @author E
 */
class CommonListItemsDialog : BaseUpGlideDialog {

    private var adapter : CommonListItemsDialogAdapter?= null
    private val list = ArrayList<String>()

    var onCommonItemClickListener : OnCommonItemClickListener<Int> ?= null

    constructor(context: Context) : super(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_list_items_dialog)

        init()
    }

    override fun initViews() {
        adapter = CommonListItemsDialogAdapter(context , list)
        itemExpandListView.adapter = adapter

        itemExpandListView.setOnItemClickListener { _, _, position, _ ->
            dismiss()
            onCommonItemClickListener?.onItemClick(position)
        }
    }

    override fun initListeners() {
        cancelBtnTextView.setOnClickListener {
            dismiss()
        }
    }

    fun setItemsText(title : String , vararg items: String){
        titleTextView.text = title

        list.clear()
        list.addAll(items)
        adapter?.notifyDataSetChanged()
    }

    fun setItemsText(title : String , items: List<String>){
        titleTextView.text = title

        list.clear()
        list.addAll(items)
        adapter?.notifyDataSetChanged()
    }


}