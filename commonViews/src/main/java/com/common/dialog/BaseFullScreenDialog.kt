package com.common.dialog

import android.content.Context
import com.common.dialog.BaseDialog
import com.ss.common.views.R
/**
 * 全屏的弹出窗。
 * @author E
 */
open class BaseFullScreenDialog : BaseDialog {

    constructor(context: Context) : super(context , R.style.fullscreen_dialog)

    override fun show() {
        super.show()

        var params = window.attributes
        params.width = context.resources.displayMetrics.widthPixels
        params.height = context.resources.displayMetrics.heightPixels
        window.attributes = params

        window.setWindowAnimations(R.style.share_style)
    }
}