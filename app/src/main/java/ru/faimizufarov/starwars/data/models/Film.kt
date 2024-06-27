package ru.faimizufarov.starwars.data.models

data class Film(
    val id: Int,
    val filmNameText: String,
    val directorNameText: String,
    val producerNameText: String,
    val releaseYearText: Int
)