package com.json.jandroid.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.ViewGroup

import com.json.base.adapter.BaseRecyclerAdapter
import com.json.base.adapter.BaseViewHolder
import com.json.jandroid.R
import com.json.jandroid.databinding.AdapterItemListBinding
import com.json.jandroid.repository.data.FirstListData

class AdapterFirstList: BaseRecyclerAdapter<FirstListData, AdapterFirstList.FirstListViewHolder>() {
    private var selectedPosition = -1
    class FirstListViewHolder(binding: AdapterItemListBinding) :
        BaseViewHolder<AdapterItemListBinding>(binding)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): FirstListViewHolder {
        return FirstListViewHolder(getBinding(parent, R.layout.adapter_item_list))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun bindHolder(holder: FirstListViewHolder, position: Int) {
        val item = getDataList()?.get(position)

        item?.icon?.let {
            holder.binding.itemIconId.setImageResource(it)
        }
        holder.binding.itemTitleId.text = item?.title ?: ""

        holder.binding.itemSubtitleId.text = item?.subTitle ?: ""
        if (position == selectedPosition) {
            holder.binding.item.setBackgroundResource(R.drawable.rounded_background_select)
            holder.binding.itemSubtitleId.setTextAppearance(R.style.first_list_text_second_select)
        } else {
           holder.binding.item.setBackgroundResource(R.drawable.rounded_background)
            holder.binding.itemSubtitleId.setTextAppearance(R.style.first_list_text_second)

        }
        holder.binding.item.setOnClickListener {
            if (selectedPosition != position) {
                selectedPosition = position
                notifyDataSetChanged()
            }
        }
    }

}
