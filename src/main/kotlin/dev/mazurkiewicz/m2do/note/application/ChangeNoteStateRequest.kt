package dev.mazurkiewicz.m2do.note.application

import dev.mazurkiewicz.m2do.note.domain.model.NoteState

data class ChangeNoteStateRequest(val state: NoteState) {

}
