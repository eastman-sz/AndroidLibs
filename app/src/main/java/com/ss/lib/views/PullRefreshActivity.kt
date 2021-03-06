package com.ss.lib.views

import android.os.Bundle
import com.common.base.BasePullToRefreshActivity
import com.common.dialog.OnCommonItemClickListener
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
        commonTitleView.onCommonItemClickListener = object : OnCommonItemClickListener<Int>(){
            override fun onItemClick(it: Int) {
                if (0 == it){
                    finish()
                }
            }
        }
    }

    override fun initViews() {

    }

}
