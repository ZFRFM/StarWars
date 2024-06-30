package ru.faimizufarov.starwars.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface AppApiInterface {
    @GET("films")
    suspend fun getFilms(): ResultResponse

    @GET("{peopleUrl}")
    suspend fun getPeopleById(@Path("peopleUrl") peopleUrl: String): CharacterResponse
}