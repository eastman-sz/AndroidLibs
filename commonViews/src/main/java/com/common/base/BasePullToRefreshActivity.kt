package com.common.base

import android.widget.ListView
import com.handmark.pulltorefresh.library.OnPullReFreshListener2
import com.handmark.pulltorefresh.library.PullToRefreshBase
/**
 * Base PullToRefreshActivity.
 * @author E
 */
open class BasePullToRefreshActivity : BaseAppCompactActivity() , OnPullReFreshListener2{

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
