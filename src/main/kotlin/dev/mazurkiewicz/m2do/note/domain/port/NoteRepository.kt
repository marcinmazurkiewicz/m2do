package dev.mazurkiewicz.m2do.note.domain.port

import dev.mazurkiewicz.m2do.note.domain.model.Note
import dev.mazurkiewicz.m2do.note.domain.model.NoteId

interface NoteRepository {

    fun save(note: Note): Note

    fun findById(id: NoteId): Note?
    fun delete(noteId: NoteId)
}