package dev.mazurkiewicz.m2do.note

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(msg : String) : RuntimeException(msg)