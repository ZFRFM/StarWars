package ru.faimizufarov.starwars.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.starwars.data.models.Film
import ru.faimizufarov.starwars.data.network.AppApi
import ru.faimizufarov.starwars.data.network.toFilm

class FilmRepository {
    private val api = AppApi.retrofitService

    suspend fun getFilms() =
        withContext(Dispatchers.IO) {
            if (isFilmsCached()) {
                getFilmsFromDatabase()
            } else {
                getFilmsFromNetwork()
            }
        }

    private suspend fun getFilmsFromNetwork() =
        api.getFilms().results.map { it.toFilm() }

    private suspend fun getFilmsFromDatabase(): List<Film> {
        TODO("Implement database")
    }

    private suspend fun isFilmsCached() = false
}