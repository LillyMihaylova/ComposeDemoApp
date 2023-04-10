package com.example.composedemoapp.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Flickr(
    @SerialName("small") var small: ArrayList<String> = arrayListOf(),
    @SerialName("original") var original: ArrayList<String> = arrayListOf()
)
