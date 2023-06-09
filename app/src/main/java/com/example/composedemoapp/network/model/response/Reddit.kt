package com.example.composedemoapp.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reddit(
    @SerialName("campaign") var campaign: String? = null,
    @SerialName("launch") var launch: String? = null,
    @SerialName("media") var media: String? = null,
    @SerialName("recovery") var recovery: String? = null
)
