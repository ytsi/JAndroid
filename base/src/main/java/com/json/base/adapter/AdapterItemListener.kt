package com.json.base.adapter


abstract class AdapterItemListener<T> {
    abstract fun itemClick(item: T?, position: Int)
}

abstract class AdapterCollectListener<T> {
    abstract fun collect(position: Int, id: String)

    abstract fun cancelCollect(position: Int, id: String)
}
