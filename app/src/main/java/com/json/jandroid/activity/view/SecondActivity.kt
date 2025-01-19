package com.json.jandroid.activity.view

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.json.base.BaseActivity
import com.json.jandroid.BR
import com.json.jandroid.R
import com.json.jandroid.databinding.ActivitySecondBinding

class SecondActivity: BaseActivity<ActivitySecondBinding, SecondViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_second
    }

    override fun getViewModelId(): Int {
        return BR.secondVM
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val decorView = window.decorView
        val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        decorView.systemUiVisibility = uiOptions

    }
    override fun initViewData() {
        binding?.lottieAnimationView?.setAnimation("remarkable.json")
        binding?.lottieAnimationView?.imageAssetsFolder = "images/"
        binding?.lottieAnimationView?.playAnimation()
        binding?.lottieAnimationView?.addAnimatorListener(object : Animator.AnimatorListener {


            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                binding?.lottieAnimationView?.visibility = View.GONE
                binding?.secondContextId?.visibility = View.VISIBLE
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }
        })
        binding?.secondCloseBtnId?.setOnClickListener{
            finish()
        }
        binding?.secondBtnId?.setOnClickListener{

        }
    }
}