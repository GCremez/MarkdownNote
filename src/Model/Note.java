package Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Note {
    private String title;
    private String content;
    private LocalDateTime date;
    private List<String> tags;

    public Note(String title, String content, List<String> tags, LocalDateTime now) {
        this.title = title;
        this.content = content;
        this.date = now;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

   public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
   }

    public String toMarkdown() {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(title).append("\n");
        sb.append("_Created at: ").append(getFormattedDate()).append("_\n");
        sb.append("Tags: ").append(String.join(", ", tags)).append("\n\n");
        sb.append(content);
        return sb.toString();
    }
}
