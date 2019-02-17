package com.techmashinani.datasourcesample.api

import com.techmashinani.datasourcesample.models.stackoverflow.AnswerResponse
import com.techmashinani.datasourcesample.models.stackoverflow.AnswerResponseList
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @Json
    @GET("answers")
    fun getAnswersAsync(
        @Query("pagesize") size: Int = 3,
        @Query("page") page: Int = 1,
        @Query("site") site: String = "stackoverflow"
    ): Deferred<Response<AnswerResponse>>

    @Json
    @GET("answers")
    fun getAnswers(
        @Query("pagesize") size: Int = 3,
        @Query("page") page: Int = 1,
        @Query("site") site: String = "stackoverflow"
    ): Deferred<AnswerResponseList>
}