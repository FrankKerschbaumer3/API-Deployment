package edge.labs.sprints

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Request to create a new set of Sprints
 */
data class SprintRequest(val maxVelocity: Int = -1, val stories: List<Story> = emptyList())


@RestController
@RequestMapping("/v1/sprints")
class SprintController(private val sprints: Sprints) {

    @GetMapping("/test")
    fun test(): SprintRequest = SprintRequest(12, listOf(Story("Hai", 3)))

    @GetMapping("/")
    fun allSprints(): List<Sprint> {
        return sprints.findAll().toList()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): Sprint {
        return sprints.findById(id).orElseThrow { SprintNotFound("Sprint $id not found") }
    }

    @PostMapping("/create")
    fun createSprintsFrom(@Valid sprintRequest: SprintRequest) {
        val newSprints = SprintSplitter.splitToSprints(sprintRequest.stories, sprintRequest.maxVelocity)

        sprints.save(newSprints)
    }

}

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Sprint")
class SprintNotFound(msg: String): Exception(msg)
