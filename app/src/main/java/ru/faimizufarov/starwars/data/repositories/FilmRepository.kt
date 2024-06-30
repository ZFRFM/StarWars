package ru.faimizufarov.starwars.data.repositories

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.starwars.data.database.AppDatabase
import ru.faimizufarov.starwars.data.database.toFilm
import ru.faimizufarov.starwars.data.models.Film
import ru.faimizufarov.starwars.data.models.toFilmEntity
import ru.faimizufarov.starwars.data.network.AppApi
import ru.faimizufarov.starwars.data.network.toFilm

class FilmRepository(
    private val context: Context
) {
    private val api = AppApi.retrofitService
    private val database = AppDatabase.getDatabase(context)

    suspend fun getFilms() =
        withContext(Dispatchers.IO) {
            if (isFilmsCached()) {
                getFilmsFromDatabase()
            } else {
                getFilmsFromNetwork()
            }
        }

    private suspend fun getFilmsFromNetwork(): List<Film> {
        val films = api.getFilms().results.map { filmResponse ->  filmResponse.toFilm() }
        database.filmDao().insertFilms(
            films.map { film -> film.toFilmEntity() }
        )
        return films
    }

    private suspend fun getFilmsFromDatabase(): List<Film> {
        val films = database.filmDao().getAllFilms()
        return films.map { filmEntity ->
            filmEntity.toFilm()
        }
    }

    private suspend fun isFilmsCached() = database.filmDao().checkFilmsCount() != 0
}