package ru.faimizufarov.starwars.data.network

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.faimizufarov.starwars.data.models.Film

@Serializable
data class FilmResponse(
    @SerialName("title") val filmName: String,
    @SerialName("episode_id") val id: Int,
    @SerialName("director") val directorName: String,
    @SerialName("producer") val producerName: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("characters") val characters: List<String>,
    @SerialName("planets") val planets: List<String>
)

fun FilmResponse.toFilm(): Film {
    val date = LocalDate.parse(releaseDate)
    return Film(
        id = id,
        filmNameText = filmName,
        directorNameText = directorName,
        producerNameText = producerName,
        releaseYearText = date.year,
        characters = characters,
        planets = planets
    )
}