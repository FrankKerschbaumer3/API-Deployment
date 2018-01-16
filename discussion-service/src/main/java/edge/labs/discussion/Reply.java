package edge.labs.discussion;

public class Reply {

    private String author;
    private String message;

    public Reply() { /* Mostly for Jackson */ }

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

    @Override
    public String toString() {
        return "Reply{" +
            "author='" + author + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
