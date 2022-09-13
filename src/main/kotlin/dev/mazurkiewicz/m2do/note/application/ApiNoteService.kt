package dev.mazurkiewicz.m2do.note.application

import dev.mazurkiewicz.m2do.note.domain.model.NoteState
import dev.mazurkiewicz.m2do.note.domain.model.*
import dev.mazurkiewicz.m2do.note.domain.port.NoteService
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class ApiNoteService(private val noteService: NoteService) {

    fun saveNote(noteRequest: NewNoteRequest): NoteResponse {
        val note = Note(
            id = null,
            title = NoteTitle(noteRequest.title),
            content = NoteContent(noteRequest.content),
            type = noteRequest.type,
            creationDate = NoteCreationDate(Instant.now()),
            editDate = NoteEditDate(Instant.now()),
            readonly = NoteReadWriteOption(false),
            state = NoteState.ACTUAL
        )
        val savedNote = noteService.saveNote(note)

        return NoteResponse.of(savedNote)
    }

    fun findNote(id: Long): NoteResponse {
        val note = noteService.findNote(NoteId(id))
        return NoteResponse.of(note)
    }

    fun changeState(noteId: Long, request: ChangeNoteStateRequest): NoteResponse {
        val note =  when (request.state) {
            NoteState.DONE -> noteService.markDone(NoteId(noteId))
            NoteState.EXPIRED -> noteService.markExpired(NoteId(noteId))
            NoteState.ACTUAL -> noteService.markActual(NoteId(noteId))
        }
        return NoteResponse.of(note)
    }

    fun editNote(id: Long, request: ChangeNoteRequest): NoteResponse {
        val note = noteService.editNote(
            id = NoteId(id),
            title = NoteTitle(request.title),
            content = NoteContent(request.content),
            type = request.type)
        return NoteResponse.of(note)
    }

    fun delete(id: Long) {
        noteService.delete(NoteId(id))
    }
}