package com.json.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<D, V : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<V>() {

    private var listData: List<D?>? = null
    private var itemListener: AdapterItemListener<D>? = null


    fun setDataList(data: List<D?>?) {
        listData = data
        notifyDataSetChanged()
    }


    fun getDataList(): List<D?>? {
        return listData
    }


    fun setItemListener(listener: AdapterItemListener<D>?) {
        itemListener = listener
    }




    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): V


    abstract fun bindHolder(holder: V, position: Int)

    fun <B : ViewDataBinding> getBinding(parent: ViewGroup, layoutId: Int): B {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layoutId, parent, false
        )
    }



    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        return getViewHolder(parent, viewType)
    }


    override fun onBindViewHolder(holder: V, position: Int) {
        holder.itemView.setOnClickListener {
            //item点击事件
            itemListener?.itemClick(getDataList()?.get(position), position)
        }
        bindHolder(holder, position)
    }

}

abstract class BaseViewHolder<B : ViewDataBinding>(b: B) :
    RecyclerView.ViewHolder(b.root) {
    var binding: B

    init {
        this.binding = b
    }
}
