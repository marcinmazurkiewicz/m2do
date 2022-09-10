package dev.mazurkiewicz.m2do.notes

import java.time.Instant

class Note(
    val id: Int,
    val type: Int,
    val title: String,
    val content: String,
    val state: Int,
    val createdAt: Instant,
    val editedAt: Instant,
    val readonly: Boolean
) {

    fun create() {

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