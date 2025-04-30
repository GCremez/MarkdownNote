package service;

import Model.Note;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class NoteManager {
    private static void saveNote(Note note) {
        // Implement the logic to save the note to a file
        // For example, you can use FileWriter or BufferedWriter to write the note content to a file
        // You can also use serialization to save the note object directly

        String fileName = sanitizeFilename(note.getTitle()) + ".md";
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            writer.write("# " + note.getTitle() + "\n");
            writer.write("Created At: " + note.getFormattedDate() + "\n");
            writer.write(note.getContent());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
