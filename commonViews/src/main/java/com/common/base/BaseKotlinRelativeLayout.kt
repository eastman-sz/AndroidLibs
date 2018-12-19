package com.common.base

import android.content.Context
import android.util.AttributeSet

open class BaseKotlinRelativeLayout : BaseRelativeLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context , attrs : AttributeSet) : super(context , attrs)

}