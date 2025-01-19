package com.json.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    open var binding: B? = null
    open var viewModel: VM? = null

    abstract fun getLayoutId(): Int

    abstract fun getViewModelId(): Int


    abstract fun initViewData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBase()
        setContentView(binding?.root)
        initViewData()
    }

    private fun initBase() {
        binding = DataBindingUtil.setContentView(this@BaseActivity, getLayoutId())

        val modelClass: Class<BaseViewModel>
        val type = javaClass.genericSuperclass
        modelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<BaseViewModel>
        } else {
            BaseViewModel::class.java
        }

        viewModel = createViewModel(this, modelClass as Class<VM>)
        binding?.setVariable(getViewModelId(), viewModel)
        binding?.lifecycleOwner = this

    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
    }

    open fun <T : ViewModel> createViewModel(activity: FragmentActivity?, cls: Class<T>?): T {
        return ViewModelProvider(activity!!)[cls!!]
    }
}
