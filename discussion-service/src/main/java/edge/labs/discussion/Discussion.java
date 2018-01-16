package edge.labs.discussion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

@Document
public class Discussion {

    @Id
    public String id;

    public String name;
    public String createdDate;
    public List<Reply> replies;

    public Discussion() {
        this.replies = Collections.emptyList();
    }

    public String getId() {
        return id;
    }

    public Discussion setId(String id) {
        this.id = id;
        return this;
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
