package com.common.base

import android.content.Context
import android.widget.TextView

class ViewHelper {

    companion object {

        fun setLeftCompoundDrawables(context: Context, textView: TextView, drawable_resid: Int) {
            if (0 == drawable_resid) {
                textView.setCompoundDrawables(null, null, null, null)

                return
            }
            val drawable = context.resources.getDrawable(drawable_resid)
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            textView.setCompoundDrawables(drawable, null, null, null)
        }

        fun setRightCompoundDrawables(context: Context, textView: TextView, drawable_resid: Int) {
            if (0 == drawable_resid) {
                textView.setCompoundDrawables(null, null, null, null)

                return
            }
            val drawable = context.resources.getDrawable(drawable_resid)
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            textView.setCompoundDrawables(null, null, drawable, null)
        }

        fun setTopCompoundDrawables(context: Context, textView: TextView, drawable_resid: Int) {
            if (0 == drawable_resid) {
                textView.setCompoundDrawables(null, null, null, null)

                return
            }
            val drawable = context.resources.getDrawable(drawable_resid)
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            textView.setCompoundDrawables(null, drawable, null, null)
        }

        fun setBottomCompoundDrawables(context: Context, textView: TextView, drawable_resid: Int) {
            if (0 == drawable_resid) {
                textView.setCompoundDrawables(null, null, null, null)

                return
            }
            val drawable = context.resources.getDrawable(drawable_resid)
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            textView.setCompoundDrawables(null, null, null, drawable)
        }

    }

}