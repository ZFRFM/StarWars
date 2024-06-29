package ru.faimizufarov.starwars.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.faimizufarov.starwars.data.models.Film

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("filmNameText") val filmNameText: String,
    @ColumnInfo("directorNameText") val directorNameText: String,
    @ColumnInfo("producerNameText") val producerNameText: String,
    @ColumnInfo("releaseYearText") val releaseYearText: Int,
    @ColumnInfo("characters") val characters: List<String>,
    @ColumnInfo("planets") val planets: List<String>
)

fun FilmEntity.toFilm() =
    Film(
        id = id,
        filmNameText = filmNameText,
        directorNameText = directorNameText,
        producerNameText = producerNameText,
        releaseYearText = releaseYearText,
        characters = characters,
        planets = planets
    )