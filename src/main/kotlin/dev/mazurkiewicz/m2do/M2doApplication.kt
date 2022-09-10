package dev.mazurkiewicz.m2do

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class M2doApplication

fun main(args: Array<String>) {
	runApplication<M2doApplication>(*args)
}
