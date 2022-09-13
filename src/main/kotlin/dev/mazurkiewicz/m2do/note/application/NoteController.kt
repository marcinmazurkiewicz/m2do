package dev.mazurkiewicz.m2do.note.application

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
}
