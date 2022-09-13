package dev.mazurkiewicz.m2do.notes.domain.model

import dev.mazurkiewicz.m2do.notes.NoteState
import dev.mazurkiewicz.m2do.notes.NoteType

class Note(
    var id: NoteId,
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