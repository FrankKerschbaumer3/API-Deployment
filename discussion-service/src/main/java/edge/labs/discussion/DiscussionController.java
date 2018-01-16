package edge.labs.discussion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/discussion")
public class DiscussionController {

    private DiscussionRepository repository;

    @Autowired
    public DiscussionController(DiscussionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Discussion> all() {
        return repository.findAll();
    }

    @PutMapping("/create/{name}")
    public Discussion create(@PathVariable("name") String name) {
        return repository.save(
            new Discussion()
                .setName(name)
                .setCreatedDate(LocalDateTime.now().toString()));
    }

    @PostMapping("/reply/{discussionId}")
    public Discussion addReply(@PathVariable("discussionId") String discussionId, Reply reply) {
        return repository.findById(discussionId)
            .map(d -> repository.save(d.withReply(reply)))
            .orElseThrow(() -> new RuntimeException("No such Discussion with ID " + discussionId));
    }

    @DeleteMapping("/{discussionId}")
    public void delete(@PathVariable("discussionId") String discussionId) {
        repository.delete(discussionId);
    }
}
