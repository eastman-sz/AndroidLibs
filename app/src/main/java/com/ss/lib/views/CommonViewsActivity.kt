package com.ss.lib.views

import android.os.Bundle
import com.common.base.BaseAppCompactActivity
import com.common.dialog.CommonDialogHelper
import com.common.dialog.OnCommonItemClickListener
import com.ss.lib.R
import kotlinx.android.synthetic.main.common_views_activity.*
import org.jetbrains.anko.startActivity

class CommonViewsActivity : BaseAppCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_views_activity)
        initActivity()
    }

    override fun initTitle() {
        commonTitleView.setCenterTitle("Common Views")
        commonTitleView.onCommonItemClickListener = object : OnCommonItemClickListener<Int>(){
            override fun onItemClick(it: Int) {
                if (0 == it){
                    finish()
                }
            }
        }
    }

    override fun initViews() {
        dialogBtn.setOnClickListener {
            CommonDialogHelper.showCommonDialog(context , "标准弹窗" , "是" , "否" , object : OnCommonItemClickListener<Int>(){
            })
        }

        titleDialogBtn.setOnClickListener {
            CommonDialogHelper.showCommonTitleDialog(context , "标准带标题弹窗" , "是" , "否" , object : OnCommonItemClickListener<Int>(){})
        }

        listDialogBtn.setOnClickListener {
            CommonDialogHelper.showCommonListItemsDialog(context , "请选择" , object : OnCommonItemClickListener<Int>(){} ,
                "A" , "B" , "C")
        }

        pullRefreshViewBtn.setOnClickListener {
            startActivity<PullRefreshActivity>()
        }

        wheelViewBtn.setOnClickListener {
            startActivity<WheelViewActivity>()
        }

        numberProgressBarBtn.setOnClickListener {
            startActivity<NumberProgressbarActivity>()
        }
    }
}
