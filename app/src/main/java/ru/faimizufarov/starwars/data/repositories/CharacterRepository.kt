package ru.faimizufarov.starwars.data.repositories

import android.content.Context
import ru.faimizufarov.starwars.data.database.AppDatabase
import ru.faimizufarov.starwars.data.models.Character
import ru.faimizufarov.starwars.data.network.AppApi
import ru.faimizufarov.starwars.data.network.CharacterResponse
import ru.faimizufarov.starwars.data.network.toCharacter

class CharacterRepository(
    private val context: Context,
    private val characterUrls: List<String>
) {
    private val api = AppApi.retrofitService
    private val database = AppDatabase.getDatabase(context)

    suspend fun getCharacterFromNetwork(): List<Character> {
        val characters = mutableListOf<CharacterResponse>()
        characterUrls.forEach {  characterUrl ->
            characters.add(api.getPeopleById(characterUrl))
        }
        return characters.map { characterResponse -> characterResponse.toCharacter() }
    }
}