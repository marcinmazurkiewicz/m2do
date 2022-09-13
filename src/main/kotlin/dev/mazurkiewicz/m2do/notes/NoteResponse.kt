package dev.mazurkiewicz.m2do.notes

import dev.mazurkiewicz.m2do.notes.domain.model.Note
import java.time.Instant

class NoteResponse(
    val id: Long,
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
                id = note.id.value,
                type = note.type,
                title = note.title.value,
                content = note.content.value,
                state = note.state,
                createdAt = note.creationDate.value,
                editedAt = note.editDate.value,
                readonly = note.readonly.value
            )
        }
    }
}