package dev.mazurkiewicz.m2do.notes

import dev.mazurkiewicz.m2do.notes.domain.model.*
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController(val repository: NoteRepository) {

    @PostMapping
    fun createNote(@RequestBody request: NewNoteRequest): Note {
        val note = Note(
            id =NoteId(0),
            title = NoteTitle(request.title),
            content = NoteContent(request.content),
            type = request.type,
            creationDate = NoteCreationDate(Instant.now()),
            editDate = NoteEditDate(Instant.now()),
            readonly = NoteReadWriteOption(false),
            state = NoteState.ACTUAL
        )
        repository.save(note)
        return note
    }

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable("id") id: Long): NoteResponse {
        val note = repository.findById(id)
        if( note != null) {
            return NoteResponse.of(note)
        }
        throw ResourceNotFoundException("Note with $id not found")
    }
}
