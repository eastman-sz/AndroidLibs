package com.ss.lib.views

import android.os.Bundle
import com.common.base.BaseAppCompactActivity
import com.common.dialog.OnCommonItemClickListener
import com.ss.lib.R
import kotlinx.android.synthetic.main.activity_wheel_view.*

class WheelViewActivity : BaseAppCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel_view)

        initActivity()
    }

    override fun initTitle() {
        commonTitleView.setCenterTitle("WheelView")
        commonTitleView.onCommonItemClickListener = object : OnCommonItemClickListener<Int>(){
            override fun onItemClick(it: Int) {
                if (0 == it){
                    finish()
                }
            }
        }
    }

    override fun initViews() {
        textWheelView.onCommonItemClickListener = object : OnCommonItemClickListener<String>(){
            override fun onItemClick(it: String) {
                runOnUiThread {
                    valueTextView.text = "当前选择: $it"
                }
            }
        }
    }

}
