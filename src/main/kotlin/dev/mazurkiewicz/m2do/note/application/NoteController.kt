package dev.mazurkiewicz.m2do.note.application

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(val apiNoteService: ApiNoteService) {

    @PostMapping
    fun createNote(@RequestBody request: NewNoteRequest): NoteResponse {
        return apiNoteService.saveNote(request)
    }

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable("id") id: Long): NoteResponse {
        return apiNoteService.findNote(id)
    }

    @PutMapping("/{id}")
    fun editNote(@PathVariable("id") id: Long,
                 @RequestBody request: ChangeNoteRequest): NoteResponse {
        return apiNoteService.editNote(id, request)
    }

    @PatchMapping("/{id}")
    fun changeState(@PathVariable("id") id: Long,
    @RequestBody request: ChangeNoteStateRequest): NoteResponse {
        return apiNoteService.changeState(id, request)
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable("id") id: Long): ResponseEntity<Any> {
        apiNoteService.delete(id)
        return ResponseEntity.status(HttpStatus.ACCEPTED).build()
    }

}
