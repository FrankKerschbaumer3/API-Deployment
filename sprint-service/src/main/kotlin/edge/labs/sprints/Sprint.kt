package edge.labs.sprints

import org.springframework.data.repository.CrudRepository
import java.util.*
import javax.persistence.*

/**
 * Repository to access stories
 */
interface Sprints : CrudRepository<Sprint, Long> {
    fun findById(id: Long): Optional<Sprint>
}

@Entity
data class Sprint(
        @Id @GeneratedValue val id: Long,
        val sprint: Int = -1,
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true) val stories: List<Story> = emptyList())

@Entity
data class Story(
        val title: String = "",
        val estimate: Int = -1,
        @Id @GeneratedValue val id: Long = -1)