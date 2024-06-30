package ru.faimizufarov.starwars.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    @SerialName("count") val count: Int,
    @SerialName("results") val results: List<FilmResponse>
)
