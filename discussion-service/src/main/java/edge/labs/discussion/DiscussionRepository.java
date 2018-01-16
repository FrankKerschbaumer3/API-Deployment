package edge.labs.discussion;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DiscussionRepository extends MongoRepository<Discussion, String> {

    Optional<Discussion> findById(String id);

}
