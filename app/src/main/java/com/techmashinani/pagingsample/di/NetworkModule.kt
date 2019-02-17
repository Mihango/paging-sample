package com.techmashinani.pagingsample.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.techmashinani.datasourcesample.api.ApiService
import com.techmashinani.pagingsample.repository.AnswerRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { GsonBuilder().create() }
    single { createOkHttpClient() }
    single { createWebService<ApiService>(get(), get()) } //, getProperty(SERVER_URL))}
    single { AnswerRepository(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, gson: Gson): T {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.stackexchange.com/2.2/")
        .client(okHttpClient)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    return retrofit.create(T::class.java)
}