package ru.evreke.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.evreke.myapplication.Note

@Entity
data class Group(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "notes_") var notes: List<Note>,
    @ColumnInfo(name = "created_at") var createdAt: String
)