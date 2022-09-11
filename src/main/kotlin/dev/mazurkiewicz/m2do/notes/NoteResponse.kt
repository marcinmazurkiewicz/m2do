package dev.mazurkiewicz.m2do.notes

import java.time.Instant

class NoteResponse(
    val id: Int,
    val type: NoteType,
    val title: String,
    val content: String,
    val state: NoteState,
    val createdAt: Instant,
    val editedAt: Instant,
    val readonly: Boolean
) {

    companion object {
        fun of(note: Note): NoteResponse {
            return NoteResponse(
                id = note.id,
                type = note.type,
                title = note.title,
                content = note.content,
                state = note.state,
                createdAt = note.createdAt,
                editedAt = note.editedAt,
                readonly = note.readonly
            )
        }
    }
}