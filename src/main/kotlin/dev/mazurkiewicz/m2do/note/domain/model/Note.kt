package dev.mazurkiewicz.m2do.note.domain.model

import java.time.Instant

class Note(
    var id: NoteId?,
    val type: NoteType,
    val title: NoteTitle,
    val content: NoteContent,
    var state: NoteState,
    val creationDate: NoteCreationDate,
    val editDate: NoteEditDate,
    val readonly: NoteReadWriteOption
) {

    fun complete() {
        state = NoteState.DONE
    }

    fun inProgress() {
        state = NoteState.ACTUAL
    }
    fun expire() {
        state = NoteState.EXPIRED
    }

    fun edit(title: NoteTitle, content: NoteContent, type: NoteType): Note {
        return Note(
            id = id,
            title = title,
            content = content,
            type = type,
            state = state,
            creationDate = creationDate,
            editDate = NoteEditDate(Instant.now()),
            readonly = readonly
        )
    }

}