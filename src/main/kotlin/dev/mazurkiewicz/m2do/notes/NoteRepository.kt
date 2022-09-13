package dev.mazurkiewicz.m2do.notes

import dev.mazurkiewicz.m2do.notes.domain.model.Note
import dev.mazurkiewicz.m2do.notes.domain.model.NoteId
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
class NoteRepository {
    val repo = mutableMapOf<Long, Note>()
    val seq = AtomicLong()

    fun save(note: Note) {
        note.id = NoteId(seq.incrementAndGet())
        repo[note.id.value] = note
    }

    fun findById(id: Long): Note? {
        return repo[id]
    }
}