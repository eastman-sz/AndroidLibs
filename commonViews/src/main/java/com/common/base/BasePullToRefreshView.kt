package com.common.base

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView
import com.handmark.pulltorefresh.library.OnPullReFreshListener2
import com.handmark.pulltorefresh.library.PullToRefreshBase
/**
 * Basic class.
 * @author E
 */
open class BasePullToRefreshView : BaseRelativeLayout , OnPullReFreshListener2 {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs : AttributeSet) : super(context , attrs)

    open fun onPullDownToRefresh(){

    }

    open fun onPullUpToRefresh(){

    }

    final override fun onPullDownToRefresh(p0: PullToRefreshBase<ListView>?) {
        onPullDownToRefresh()
    }

    final override fun onPullUpToRefresh(p0: PullToRefreshBase<ListView>?) {
        onPullUpToRefresh()
    }
}