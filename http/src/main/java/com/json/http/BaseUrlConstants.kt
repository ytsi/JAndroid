package com.json.http

object BaseUrlConstants {
    private const val baseUrl: String = "http://192.168.3.225:5000/"

    fun getHost(): String {
        return baseUrl
    }

}
