package dev.mazurkiewicz.m2do.notes

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import kotlin.random.Random

@RestController
@RequestMapping("/notes")
class NoteController {

    @PostMapping
    fun createNote(@RequestBody request: NewNoteRequest): Note {
        val note = Note(
            id = Random.nextInt(),
            title = request.title,
            content = request.content,
            type = request.type,
            createdAt = Instant.now(),
            editedAt = Instant.now(),
            readonly = false,
            state = 1
        )
        return note
    }
}