package edge.labs.discussion;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Discussion {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String createdDate;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private List<Reply> replies;

    public Discussion() {
        this.replies = Collections.emptyList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Discussion setName(String name) {
        this.name = name;
        return this;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public Discussion setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public Discussion setReplies(List<Reply> replies) {
        this.replies = replies;
        return this;
    }

    public Discussion withReply(Reply reply) {
        this.replies.add(reply);

        return this;
    }

    @Override
    public String toString() {
        return "Discussion{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", createdDate='" + createdDate + '\'' +
            ", replies=" + replies +
            '}';
    }
}
