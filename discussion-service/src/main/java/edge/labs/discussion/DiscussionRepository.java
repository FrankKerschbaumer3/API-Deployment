package edge.labs.discussion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {

    Optional<Discussion> findById(Long id);

}
