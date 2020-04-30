package ru.evreke.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey
    var id: Long,
    var title: String,
    var body: String,
    //TODO: Probably change it to LocalDateTime in future
    var createdAt: String
)