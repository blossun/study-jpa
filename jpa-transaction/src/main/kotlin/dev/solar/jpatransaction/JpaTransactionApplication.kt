package dev.solar.jpatransaction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaTransactionApplication

fun main(args: Array<String>) {
    runApplication<JpaTransactionApplication>(*args)
}
