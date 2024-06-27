package ru.faimizufarov.starwars.data.network

import retrofit2.http.GET

interface AppApiInterface {
    @GET("films")
    suspend fun getFilms(): ResultResponse
}