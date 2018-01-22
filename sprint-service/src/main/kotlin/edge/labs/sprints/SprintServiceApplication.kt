package edge.labs.sprints

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SprintServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(SprintServiceApplication::class.java, *args)
}
