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

        fun setLeftAndRightCompoundDrawables(context: Context, textView: TextView, leftDrawable_resid: Int , rightDrawable_resid: Int){
            if (0 == leftDrawable_resid && 0 == rightDrawable_resid){
                textView.setCompoundDrawables(null, null, null, null)
                return
            }
            if (0 == leftDrawable_resid){
                setRightCompoundDrawables(context , textView , rightDrawable_resid)
                return
            }
            if (0 == rightDrawable_resid){
                setLeftCompoundDrawables(context , textView , leftDrawable_resid)
                return
            }
            val drawableLeft = context.resources.getDrawable(leftDrawable_resid)
            drawableLeft.setBounds(0, 0, drawableLeft.minimumWidth, drawableLeft.minimumHeight)

            val drawableRight = context.resources.getDrawable(rightDrawable_resid)
            drawableRight.setBounds(0, 0, drawableRight.minimumWidth, drawableRight.minimumHeight)

            textView.setCompoundDrawables(drawableLeft, null, drawableRight, null)
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