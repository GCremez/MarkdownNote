package controller;

import service.NoteManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Model.Note;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Welcome to the Note Manager!");
            System.out.println("1. Create Note");
            System.out.println("2. List Notes");
            System.out.println("3. View Note");
            System.out.println("4. Edit Note");
            System.out.println("5. Search Notes");
            System.out.println("6. List with Previews");
            System.out.println("7. Delete Note");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();



            switch (choice) {
                case "1":
                    System.out.print("Enter Note Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Note Content (type 'exit' to finish): ");
                    StringBuilder content = new StringBuilder();
                    System.out.print("🏷️ Tags (comma separated): ");
                    List<String> tags = Arrays.asList(scanner.nextLine().split(","));


                    Note note = new Note(title, content.toString(), tags, LocalDateTime.now());
                    NoteManager.saveNote(note);
                    break;

                case "2":
                    NoteManager.listNotes();
                    break;

                case "3":
                    System.out.println("Enter File Name to View: ");
                    String filename = scanner.nextLine();
                    NoteManager.viewNote(filename);
                    break;

                case "4":
                    System.out.print("Enter filename to edit (with .md): ");
                    String editFile = scanner.nextLine();
                    NoteManager.editNote(editFile, scanner);
                    break;

                case "5":
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    NoteManager.searchNote(keyword);
                    break;

                case "6":
                    NoteManager.listNotesWithPreview();
                    break;

                case "7":
                    System.out.print("🗑️ Enter filename to delete: ");
                    String toDelete = scanner.nextLine();
                    NoteManager.deleteNote(toDelete, scanner);
                    break;


                case "0":
                    System.out.println("Exiting Note Manager. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}