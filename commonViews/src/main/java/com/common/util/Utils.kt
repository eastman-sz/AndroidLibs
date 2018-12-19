package com.common.util

import android.content.Context
import java.lang.reflect.Field

class Utils {

    companion object {

        /**
         * 根据手机的分辨率从 DP 的单位 转成为 PX(像素)。
         * @param context 上下文环境
         * @param dpValue DP值
         * @return PX值
         */
        fun dip2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }

        /**
         * StatusBarHeight
         * @param context
         * @return StatusBarHeight
         */
        fun getStatusBarHeight(context: Context): Int {
            var c: Class<*>? = null
            var obj: Any? = null
            var field: Field? = null
            var x = 0
            var sbar = 0
            try {
                c = Class.forName("com.android.internal.R\$dimen")
                obj = c!!.newInstance()
                field = c.getField("status_bar_height")
                x = Integer.parseInt(field!!.get(obj).toString())
                sbar = context.resources.getDimensionPixelSize(x)
                return sbar
            } catch (e1: Exception) {
                e1.printStackTrace()
            }

            return 0
        }

    }

}