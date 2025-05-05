package service;

import Model.Note;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class NoteManager {
    public static void saveNote(Note note) {

        // Implement the logic to save the note to a file.
        // For example, you can use FileWriter or BufferedWriter to write the note content to a file
        // You can also use serialization to save the note object directly

        String fileName = sanitizeFilename(note.getTitle()) + ".md";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("# " + note.getTitle() + "\n");
            writer.write("Created At: " + note.getFormattedDate() + "_\n\n");
            writer.write(note.getContent());
            System.out.println("✅ Note saved to " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Failed to save note: " + e.getMessage());
        }
    }


    public static void listNotes() {
        File folder = new File(".");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".md"));
        if (files == null || files.length == 0) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("\n Available Notes:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }
    }

    public static void viewNote(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("❌ Note not found: " + fileName);
                return;
            }

            System.out.println("Previewing " + fileName);
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);

        } catch (IOException e) {
            System.out.println("❌ Failed to read note: " + e.getMessage());
        }
    }


    public static void editNote(String fileName, Scanner scanner) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("❌ Note not found: " + fileName);
            return;
        }

        try {
            String oldContent = new String(Files.readAllBytes(file.toPath()));
            System.out.println("\n Current Content:\n" + oldContent);
            System.out.println(" Enter new content (type 'exit' to finish): ");
            String newContent = scanner.nextLine();

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(oldContent.split("\n\n")[0] + "\n\n");
                writer.write(oldContent.split("\n\n")[1] + "\n\n");
                writer.write(newContent);
                System.out.println("✅ Note updated successfully.");
            }
        } catch (IOException e) {
            System.out.println("❌ Failed to update note: " + e.getMessage());
        }
    }

    public static void searchNote(String keyboard) {
        File folder = new File(".");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".md"));
        boolean found = false;

        for (File file : files) {
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                if (content.toLowerCase().contains(keyboard
                        .toLowerCase())) {
                    System.out.println("Found in " + file.getName() + ": " + content);
                    found = true;
                }
            } catch (IOException e) {
                System.out.println("❌ Failed to read note: " + file.getName());
            }
        }

        if (!found) {
            System.out.println("No notes found containing: " + keyboard);
        }
    }

    public static void listNotesWithPreview() {
        File folder = new File (".");
        File[] files =  folder.listFiles((dir, name) -> name.endsWith(".md"));

        if (files == null || files.length == 0) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("\n Available Notes:");
        for (File file : files) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                String preview = (lines.size() >= 3) ? lines.get(2) : "No preview available";
                System.out.println("• " + file.getName() + " → " + preview);
            } catch (IOException e) {
                System.out.println("❌ Failed to read note: " + file.getName());
            }
        }
    }

    public static void deleteNote(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if(file.delete()) {
                System.out.println("✅ Note deleted successfully.");
            } else {
                System.out.println("❌ Failed to delete note.");
            }
        } else {
            System.out.println("❌ Note does not exist: " + fileName);
        }
    }


    // This method can be used to sanitize the filename by removing or replacing invalid characters
    private static String sanitizeFilename(String title) {
        return title;
    }
}
