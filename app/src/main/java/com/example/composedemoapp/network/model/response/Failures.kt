package com.example.composedemoapp.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Failures(
    @SerialName("time") var time: Int? = null,
    @SerialName("altitude") var altitude: String? = null,
    @SerialName("reason") var reason: String? = null
)
