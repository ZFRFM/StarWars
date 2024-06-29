package ru.faimizufarov.starwars.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.faimizufarov.starwars.data.models.Character

@Serializable
data class CharacterResponse(
    @SerialName("name") val name: String,
    @SerialName("birth_year") val birthYear: String,
    @SerialName("gender") val gender: String,
    @SerialName("homeworld") val homeworld: String,
)

fun CharacterResponse.toCharacter() =
    Character(
        name = name,
        gender = gender,
        birthDate = birthYear,
        homeworld = homeworld
    )