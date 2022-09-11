package dev.mazurkiewicz.m2do.notes

import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.service.annotation.HttpExchange
import java.time.Instant
import kotlin.random.Random

@RestController
@RequestMapping("/notes")
class NoteController(val repository: NoteRepository) {

    @PostMapping
    fun createNote(@RequestBody request: NewNoteRequest): Note {
        val note = Note(
            id = 0,
            title = request.title,
            content = request.content,
            type = request.type,
            createdAt = Instant.now(),
            editedAt = Instant.now(),
            readonly = false,
            state = NoteState.ACTUAL
        )
        repository.save(note)
        return note
    }

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable("id") id: Int): NoteResponse {
        val note = repository.findById(id)
        if( note != null) {
            return NoteResponse.of(note)
        }
        throw ResourceNotFoundException("Note with $id not found")
    }
}
