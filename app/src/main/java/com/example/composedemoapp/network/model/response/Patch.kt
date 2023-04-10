package com.example.composedemoapp.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Patch(
    @SerialName("small") var small: String? = null,
    @SerialName("large") var large: String? = null
)