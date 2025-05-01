package controller;

import service.NoteManager;
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
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();



            switch (choice) {
                case "1":
                    System.out.print("Enter Note Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Note Content (type 'exit' to finish): ");
                    StringBuilder content = new StringBuilder();
                    Note note = new Note(title, content.toString());
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
                    System.out.println("Exiting Note Manager. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}