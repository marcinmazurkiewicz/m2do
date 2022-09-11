package dev.mazurkiewicz.m2do.notes

import java.time.Instant

class Note(
    val id: Int,
    val type: NoteType,
    val title: String,
    val content: String,
    val state: NoteState,
    val createdAt: Instant,
    val editedAt: Instant,
    val readonly: Boolean
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