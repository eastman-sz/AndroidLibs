package com.ss.lib.views

import android.os.Bundle
import com.common.base.BasePullToRefreshActivity
import com.ss.lib.R
import kotlinx.android.synthetic.main.activity_pull_refresh.*

class PullRefreshActivity : BasePullToRefreshActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_refresh)

        initActivity()
    }

    override fun initTitle() {
        commonTitleView.setCenterTitle("PullRefresh")
        commonTitleView.setLeftBtnBackground(0)
    }

    override fun initViews() {

    }

}
