package com.techmashinani.datasourcesample.api

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class SampleCallAdapter private constructor(): CallAdapter.Factory() {
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        return null
    }
}