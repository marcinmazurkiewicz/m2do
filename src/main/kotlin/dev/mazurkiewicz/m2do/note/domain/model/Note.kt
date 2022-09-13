package dev.mazurkiewicz.m2do.note.domain.model

class Note(
    var id: NoteId?,
    val type: NoteType,
    val title: NoteTitle,
    val content: NoteContent,
    val state: NoteState,
    val creationDate: NoteCreationDate,
    val editDate: NoteEditDate,
    val readonly: NoteReadWriteOption
) {

    fun duplicate() {

    }

    fun delete() {

    }

    fun share() {

    }

    fun edit() {

    }

    fun done() {

    }

    fun expired() {

    }
}