package ru.faimizufarov.starwars.data.repositories

import android.content.Context
import ru.faimizufarov.starwars.data.database.AppDatabase
import ru.faimizufarov.starwars.data.models.Character
import ru.faimizufarov.starwars.data.network.AppApi

class CharacterRepository(
    private val context: Context,
) {
    private val api = AppApi.retrofitService
    private val database = AppDatabase.getDatabase(context)

    suspend fun getCharacterFromNetwork(characterUrls: List<String>): List<Character> {
        TODO("Implement getCharacterFromNetwork()")
    }
}