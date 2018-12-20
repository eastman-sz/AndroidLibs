package com.ss.lib.views

import android.os.Bundle
import android.widget.Toast
import com.common.base.BaseAppCompactActivity
import com.common.dialog.OnCommonItemClickListener
import com.progress.OnProgressBarListener
import com.ss.lib.R
import kotlinx.android.synthetic.main.activity_number_progressbar.*
import java.util.*

class NumberProgressbarActivity : BaseAppCompactActivity() {

    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_progressbar)

        initActivity()
    }

    override fun initTitle() {
        commonTitleView.setCenterTitle("NumberProgressbar")
        commonTitleView.onCommonItemClickListener = object : OnCommonItemClickListener<Int>(){
            override fun onItemClick(it: Int) {
                if (0 == it){
                    finish()
                }
            }
        }
    }

    override fun initViews() {
        numberbar1.setOnProgressBarListener(object : OnProgressBarListener{
            override fun onProgressChange(current: Int, max: Int) {
                if (current == max){
                    Toast.makeText(context , "ProgressBar is finished." , Toast.LENGTH_SHORT).show()
                    numberbar1.progress = 0
                }
            }
        })

        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    numberbar1.incrementProgressBy(1)
                }
            }
        }, 1000, 100)
    }

    override fun onDestroy() {
        timer?.cancel()
        super.onDestroy()
    }


}
