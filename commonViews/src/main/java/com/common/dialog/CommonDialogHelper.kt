package com.common.dialog

import android.content.Context

class CommonDialogHelper {

    companion object {

        fun showCommonDialog(context: Context ,content : String , leftBtnText : String , rightBtnText : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?){
            val dialog = CommonDialog(context)
            dialog.show()
            dialog.setParams(content , leftBtnText , rightBtnText , onCommonItemClickListener)
        }

        fun showCommonTitleDialog(context: Context ,content : String , leftBtnText : String , rightBtnText : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?){
            val dialog = CommonTitleDialog(context)
            dialog.show()
            dialog.setParams(content , leftBtnText , rightBtnText , onCommonItemClickListener)
        }

        fun showCommonTitleDialog(context: Context , title: String , content : String , leftBtnText : String , rightBtnText : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?){
            val dialog = CommonTitleDialog(context)
            dialog.show()
            dialog.setParams(title , content , leftBtnText , rightBtnText , onCommonItemClickListener)
        }

        fun showCommonListItemsDialog(context: Context , title : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?  ,vararg items: String){
            val dialog = CommonListItemsDialog(context)
            dialog.show()
            val list = items.toList()
            dialog.setItemsText(title , list)
            dialog.onCommonItemClickListener = onCommonItemClickListener
        }

        fun showCommonSingleBtnDialog(context: Context , content : String , btnText : String , onCommonItemClickListener : OnCommonItemClickListener<Int> ?){
            val dialog = CommonSingleBtnDialog(context)
            dialog.show()
            dialog.setParams(content , btnText , onCommonItemClickListener)

        }

    }

}