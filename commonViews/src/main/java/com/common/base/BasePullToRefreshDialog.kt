package com.common.base

import android.content.Context
import android.widget.ListView
import com.common.dialog.BaseFullScreenDialog
import com.handmark.pulltorefresh.library.OnPullReFreshListener2
import com.handmark.pulltorefresh.library.PullToRefreshBase
/**
 * 全屏上下拉刷新的基础弹出窗。
 * @author E
 */
open class BasePullToRefreshDialog : BaseFullScreenDialog  , OnPullReFreshListener2 {

    constructor(context: Context) : super(context)

    open fun onPullDownToRefresh(){

    }

    open fun onPullUpToRefresh(){

    }

    final override fun onPullDownToRefresh(refreshView: PullToRefreshBase<ListView>?) {
        onPullDownToRefresh()
    }

    final override fun onPullUpToRefresh(refreshView: PullToRefreshBase<ListView>?) {
        onPullUpToRefresh()
    }
}