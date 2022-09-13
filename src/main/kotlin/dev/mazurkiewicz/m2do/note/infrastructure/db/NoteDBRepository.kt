package dev.mazurkiewicz.m2do.note.infrastructure.db

import dev.mazurkiewicz.m2do.note.domain.model.Note
import dev.mazurkiewicz.m2do.note.domain.model.NoteId
import dev.mazurkiewicz.m2do.note.domain.port.NoteRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
class NoteDBRepository : NoteRepository {
    val repo = mutableMapOf<Long, Note>()
    val seq = AtomicLong()

    override fun save(note: Note): Note {
        note.id = NoteId(seq.incrementAndGet())
        repo[note.id!!.value] = note
        return note
    }

    override fun findById(id: NoteId): Note? {
        return repo[id.value]
    }
}