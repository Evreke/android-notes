package ru.evreke.myapplication

data class Group(
    var id: Long,
    var title: String,
    var notes: List<Note>,
    var createdAt: String
)