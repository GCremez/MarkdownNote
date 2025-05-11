# 📝 Markdown Note Manager - CLI App (Java)

A simple Java-based CLI app to **create**, **view**, **edit**, **search**, and **delete** Markdown notes — with tags, previews, and backup support.

---

## 📦 Features
- 📄 Create notes with title, content, and tags
- 📋 List all notes or with content preview
- 🔍 Search notes by keyword
- 🖊️ Edit notes directly in the CLI
- 🗂️ Backup all notes by date
- 🗑️ Delete notes with confirmation
- 🧪 Tested using JUnit

---

## 🛠️ Tech Stack
- Java 17+
- JUnit 5 (for testing)
- Plain Markdown `.md` files
- File-based storage (no DB needed)

---

## 📁 Project Structure

```
src/
├── controller/         # CLI logic
│   └── Main.java
├── model/              # Note model class
│   └── Note.java
├── service/            # Business logic
│   └── NoteManager.java
└── test/               # JUnit tests
    └── NoteManagerTest.java

notes/                  # Folder where notes are saved
backup/                 # Daily backups
```

---

## 🚀 How to Run

1. **Compile:**
```bash
javac -d out src/**/*.java
```

2. **Run:**
```bash
java -cp out controller.Main
```

3. **Run Tests:**
Use your IDE or:
```bash
javac -cp .:junit-platform-console-standalone.jar test/**/*.java
java -jar junit-platform-console-standalone.jar -cp . --scan-class-path
```

---

## ✅ Sample Note Format (Markdown)

```md
# My Awesome Note

📅 Created on: 2025-05-11  
🏷️ Tags: java, productivity, markdown

This is the content of the note...

- It supports markdown
- And has a readable format!
```

---

## 🔒 Sanitization

All note titles are sanitized to avoid invalid file names (e.g., `*`, `|`, `/` etc.).

---

## 📦 Backup Strategy

Every time the app is run, it can back up the `notes/` folder into a `backup/notes-yyyy-MM-dd/` folder.

---

## 🧪 Tests Covered
- Create and save note
- List notes
- View note content
- Backup folder creation
- Delete note
- Search notes
- Handle empty note list

---

## 💡 Future Ideas
- 🔐 Password-protect notes
- ☁️ Sync with cloud (e.g., Google Drive API)
- 🌐 Web-based version (Spring Boot)