package dev.mazurkiewicz.m2do.note.domain.port

import dev.mazurkiewicz.m2do.note.infrastructure.db.NoteDBRepository
import dev.mazurkiewicz.m2do.note.ResourceNotFoundException
import dev.mazurkiewicz.m2do.note.domain.model.*

class NoteService(private val repository: NoteDBRepository) {

    fun saveNote(note: Note): Note {
        return repository.save(note)
    }

    fun findNote(noteId: NoteId): Note {
        return repository.findById(noteId) ?: throw ResourceNotFoundException("Note with ${noteId.value} not found")
    }

    fun delete(noteId: NoteId) {
        repository.delete(noteId)
    }

    fun markDone(noteId: NoteId): Note {
        val note = repository.findById(noteId) ?: throw ResourceNotFoundException("Note with ${noteId.value} not found")
        note.complete()
        return repository.save(note)
    }

    fun markExpired(noteId: NoteId): Note {
        val note = repository.findById(noteId) ?: throw ResourceNotFoundException("Note with ${noteId.value} not found")
        note.expire()
        return repository.save(note)
    }

    fun markActual(noteId: NoteId): Note {
        val note = repository.findById(noteId) ?: throw ResourceNotFoundException("Note with ${noteId.value} not found")
        note.inProgress()
        return repository.save(note)
    }

    fun editNote(id: NoteId, title: NoteTitle, content: NoteContent, type: NoteType): Note {
        val note = findNote(id)
        val editedNote = note.edit(title, content, type)
        return repository.save(editedNote)
    }
}