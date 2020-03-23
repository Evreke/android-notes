package ru.evreke.myapplication

import retrofit2.http.GET

interface Api {
    @GET("group")
    suspend fun fetchAllGroups(): List<Group>

    @GET("note")
    suspend fun fetchAllNotes(): List<Note>
}