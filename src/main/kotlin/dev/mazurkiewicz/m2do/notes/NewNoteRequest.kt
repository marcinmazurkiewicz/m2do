package dev.mazurkiewicz.m2do.notes

data class NewNoteRequest(
    val title: String,
    val content: String,
    val type: NoteType,
) {
}