package edge.labs.discussion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public List<Discussion> all() {
        return repository.findAll();
    }

    @PutMapping("/create/{name}")
    @Transactional
    public Discussion create(@PathVariable("name") String name) {
        return repository.save(
            new Discussion()
                .setName(name)
                .setCreatedDate(LocalDateTime.now().toString()));
    }

    @PostMapping("/reply/{discussionId}")
    @Transactional
    public Discussion addReply(@PathVariable("discussionId") Long discussionId, @RequestBody Reply reply) {
        return repository.findById(discussionId)
            .map(d -> d.addReply(reply))
            .map(d -> repository.save(d))
            .orElseThrow(() -> new RuntimeException("No such Discussion with ID " + discussionId));
    }

    @DeleteMapping("/{discussionId}")
    @Transactional
    public void delete(@PathVariable("discussionId") Long discussionId) {
        repository.delete(discussionId);
    }
}
