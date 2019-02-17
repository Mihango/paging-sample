package com.techmashinani.datasourcesample.api

import okhttp3.Interceptor
import okhttp3.Request

object ApiFactory {
    // adding authorization headers
    val authInterceptor = Interceptor { chain ->
        var request = chain.request()
        if(request.header("No-Auth") != null) {
            request = request.newBuilder()
                .addHeader("Authorization", "Here")
                .build();
        }

        return@Interceptor chain.proceed(request)
    }

    // adding query parameters
    val authParamInterceptor = Interceptor { chain ->
        var request = chain.request()
        val url = request.url().newBuilder().addQueryParameter("key", "Key here")
            .build()
        request = request.newBuilder()
            .url(url)
            .build()
        return@Interceptor chain.proceed(request)
    }
}