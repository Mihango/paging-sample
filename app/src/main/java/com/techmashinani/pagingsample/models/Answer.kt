package com.techmashinani.pagingsample.models

import com.google.gson.annotations.SerializedName

data class Answer(
    var owner: Owner?,

    @SerializedName("is_accepted")
    var isAccepted: Boolean?,

    var score: Int?,

    @SerializedName("last_activity_date")
    var lastActivityDate: Int?,

    @SerializedName("creation_date")
    var creationDate: Int?,

    @SerializedName("answer_id")
    var answerId: Int?,

    @SerializedName("question_id")
    var questionId: Int?
)