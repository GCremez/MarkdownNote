package test.java.notemanager;

import Model.Note;
import org.junit.jupiter.api.*;
import service.NoteManager;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class NoteManagerTest {

    @Test
    void testCreateNote() {
        String testTitle = "JUnitTestNote";
        Note note = new Note(testTitle, "Test content", List.of("test", "unit"), java.time.LocalDateTime.now());
        NoteManager.saveNote(note);


        File file = new File("notes/JUnitTestNote.md");
        assertTrue(file.exists(), "File should be created");
    }

    @Test
    void testBackupNotesCreatesFolder() {
        NoteManager.backupNotes();
        File backupFolder = new File("backup/notes-" + java.time.LocalDate.now());
        assertTrue(backupFolder.exists(), "Backup Folder Should Exits");
    }

    @AfterEach
    void cleanup() {
        File file = new File("notes/JUnitTestNote.md");
        if (file.exists()) file.delete();
    }

}
