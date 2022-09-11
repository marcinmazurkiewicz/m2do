package dev.mazurkiewicz.m2do.notes

import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicInteger

@Repository
class NoteRepository {
    val repo = mutableMapOf<Int, Note>()
    val seq = AtomicInteger()

    fun save(note: Note) {
        note.id = seq.incrementAndGet()
        repo[note.id] = note
    }

    fun findById(id: Int): Note? {
        return repo[id]
    }
}