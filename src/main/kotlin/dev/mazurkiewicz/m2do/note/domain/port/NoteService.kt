package dev.mazurkiewicz.m2do.note.domain.port

import dev.mazurkiewicz.m2do.note.infrastructure.db.NoteDBRepository
import dev.mazurkiewicz.m2do.note.ResourceNotFoundException
import dev.mazurkiewicz.m2do.note.domain.model.Note
import dev.mazurkiewicz.m2do.note.domain.model.NoteId

class NoteService(private val repository: NoteDBRepository) {

    fun saveNote(note: Note): Note {
        return repository.save(note)
    }

    fun findNote(noteId: NoteId): Note {
        return repository.findById(noteId) ?: throw ResourceNotFoundException("Note with ${noteId.value} not found")

    }
}