package com.ss.lib

import android.os.Bundle
import com.common.base.BaseAppCompactActivity
import com.ss.lib.views.CommonViewsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseAppCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActivity()
    }

    override fun initTitle() {
        commonTitleView.setCenterTitle("Home Page")
        commonTitleView.setLeftBtnBackground(0)
    }

    override fun initListener() {
        commonViewsBtn.setOnClickListener {
            startActivity<CommonViewsActivity>()
        }
    }

}
