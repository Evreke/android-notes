package ru.evreke.myapplication

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.evreke.myapplication.data.model.Group

interface Api {
    @GET("group")
    suspend fun fetchAllGroups(): List<Group>

    @GET("note")
    suspend fun fetchAllNotes(): List<Note>

    @POST("note")
    suspend fun createNote(@Body note: Note) : Note
}