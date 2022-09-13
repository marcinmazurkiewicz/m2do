package dev.mazurkiewicz.m2do.note.application

import dev.mazurkiewicz.m2do.note.domain.model.NoteType

data class ChangeNoteRequest(
    val title: String,
    val content: String,
    val type: NoteType
)
