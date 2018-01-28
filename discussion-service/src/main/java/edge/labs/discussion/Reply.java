package edge.labs.discussion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reply {

    @Id
    @GeneratedValue
    private Long id;

    private String author;
    private String message;

    @ManyToOne
    @JsonIgnore
    private Discussion discussion;

    Reply() { /* For Jackson/JPA */ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    @Override
    public String toString() {
        return "Reply{" +
            "id=" + id +
            ", author='" + author + '\'' +
            ", message='" + message + '\'' +
            ", discussion=" + discussion.getId() +
            '}';
    }
}
