package com.json.http

import java.io.Serializable

class BaseResponse<T> : Serializable {

    private var errorMsg: String? = null
    private var errorCode: Int? = null
    private var data: T? = null


    fun getErrMsg(): String? {
        return errorMsg
    }

    fun setErrMsg(message: String?) {
        this.errorMsg = message
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

    fun getErrCode(): Int? {
        return errorCode
    }

    fun setErrCode(errCode: Int?) {
        this.errorCode = errCode
    }
}

