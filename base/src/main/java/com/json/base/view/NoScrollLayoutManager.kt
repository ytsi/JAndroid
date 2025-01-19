package com.json.base.view

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

/**
 * 禁止RecyclerView滑动的布局管理器
 */
class NoScrollLayoutManager(context: Context, spanCount: Int) : GridLayoutManager(
    context,
    spanCount
) {
    override fun canScrollVertically(): Boolean {
        return false
    }
}
