package hillermann.carl.learning.kotlin.spring.rest.simple

import org.springframework.boot.SpringApplication.*
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    run(Application::class.java, *args)
}