package com.json.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    open var binding: B? = null
    open var viewModel: VM? = null


    abstract fun getLayoutId(): Int

    abstract fun getViewModelId(): Int
    abstract fun initViewData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<B>(
            LayoutInflater.from(context), getLayoutId(),
            container, false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBase()
        initViewData()
    }

    private fun initBase() {
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


    open fun <T : ViewModel> createViewModel(fragment: Fragment?, cls: Class<T>?): T {
        return ViewModelProvider(fragment!!)[cls!!]
    }
}
