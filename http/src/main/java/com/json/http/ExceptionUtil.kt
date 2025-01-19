package com.json.http

import android.accounts.NetworkErrorException
import android.util.MalformedJsonException
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import org.json.JSONException

import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException


object ExceptionUtil {
    /**
     * unknown
     */
    const val UNKNOWN = 1000

    /**
     * parse error
     */
    const val PARSE_ERROR = 1001

    /**
     * network
     */
    const val NETWORK_ERROR = 1002

    /**
     * http error
     */
    const val HTTP_ERROR = 1003

    /**
     * exception
     */
    fun catchException(e: Throwable) {
        e.printStackTrace()



        when (e) {
            is HttpException -> {
            }

            is SocketTimeoutException -> {
//                showToast(R.string.common_error_net_time_out)
            }

            is UnknownHostException, is NetworkErrorException -> {
//                showToast(R.string.common_error_net)
            }

            is MalformedJsonException, is JsonSyntaxException -> {
//                showToast(R.string.common_error_server_json)
            }

            is InterruptedIOException -> {
            }
            is ApiException -> {
            }

            is ConnectException -> {
            }

            else -> {

            }
        }
    }

    private fun handleException(e: Throwable): ApiException {
        val ex: ApiException
        return if (e is JsonParseException
            || e is JSONException
            || e is ParseException
        ) {
            ex = ApiException(PARSE_ERROR, e.message)
            ex
        } else if (e is ConnectException) {
            ex = ApiException(
                NETWORK_ERROR,
                e.message
            )
            ex
        } else if (e is UnknownHostException || e is SocketTimeoutException) {
            ex = ApiException(
                NETWORK_ERROR,
                e.message
            )
            ex
        } else {
            ex = ApiException(
                UNKNOWN,
                e.message
            )
            ex
        }
    }




}
