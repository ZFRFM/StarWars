package ru.faimizufarov.starwars.data.models

import ru.faimizufarov.starwars.data.database.FilmEntity

data class Film(
    val id: Int,
    val filmNameText: String,
    val directorNameText: String,
    val producerNameText: String,
    val releaseYearText: Int,
    val characters: List<String>,
    val planets: List<String>
)

fun Film.toFilmEntity() =
    FilmEntity(
        id = id,
        filmNameText = filmNameText,
        directorNameText = directorNameText,
        producerNameText = producerNameText,
        releaseYearText = releaseYearText,
        characters = characters,
        planets = planets
    )