package dev.mazurkiewicz.m2do.note.infrastructure.config

import dev.mazurkiewicz.m2do.note.infrastructure.db.NoteDBRepository
import dev.mazurkiewicz.m2do.note.domain.port.NoteService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NoteConfig {

    @Bean
    fun noteService(noteRepository: NoteDBRepository): NoteService {
        return NoteService(noteRepository)
    }
}