package com.borosbence.rfca.network.core

import okhttp3.OkHttpClient

/**
 * This creates HttpClients.
 *
 * If you want to use interceptors, swap http client, authorize your requests in one place, you should do it here.
 */
class HttpClientFactory {

    companion object {
        fun getClient(): OkHttpClient {
            return OkHttpClient.Builder().build()
        }
    }
}