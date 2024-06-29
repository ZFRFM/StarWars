package ru.faimizufarov.starwars.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmDao {
    @Query("SELECT * FROM films WHERE id = :id")
    suspend fun getFilmById(id: String): FilmEntity

    @Query("SELECT * FROM  films")
    suspend fun getAllFilms(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilms(films: List<FilmEntity>)

    @Query("SELECT COUNT(*) FROM films")
    suspend fun checkFilmsCount(): Int
}