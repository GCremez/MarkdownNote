package Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Note {
    private String title;
    private String content;
    private LocalDateTime date;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
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

   public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
   }
}
