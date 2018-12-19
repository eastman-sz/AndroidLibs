package com.common.dialog

import android.content.Context
import android.view.Gravity
import com.common.dialog.BaseDialog
import com.ss.common.views.R
/**
 * UpGlide and fullScreen dialog.
 * @author E
 */
open class BaseUpGlideDialog : BaseDialog {

    constructor(context: Context) : super(context , R.style.fullscreen_dialog)

    override fun show() {
        window.setGravity(Gravity.BOTTOM)
        window.setWindowAnimations(R.style.share_style)
        super.show()

        val params = window.attributes
        params.width = context.resources.displayMetrics.widthPixels
        window.attributes = params

    }
}