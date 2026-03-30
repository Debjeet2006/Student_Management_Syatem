# 🎓 Student Management System (Java)

## 📌 Project Overview

This project is a **Student Management System** developed in Java that allows users to manage student records efficiently using both:

* 🖥️ Command Line Interface (CLI)
* 🪟 Graphical User Interface (GUI)

The system supports full CRUD operations (Create, Read, Update, Delete) along with file storage and multithreading for automatic data saving.

---

## 🎯 Features

### ✅ Core Features

* Add Student
* View All Students
* Search Student by ID
* Update Student Details
* Delete Student

### ⭐ Advanced Features

* File Handling (data persistence using `data.txt`)
* Multithreading (Auto-save every 5 seconds)
* Input Validation (no invalid data allowed)
* Duplicate ID Prevention
* User-friendly GUI using Java Swing
* JTable for structured data display
* Confirmation dialogs for safe deletion

---

## 🧠 Technologies Used

* Java (Core + OOP)
* Java Swing (GUI)
* Java Collections (`ArrayList`)
* File Handling (BufferedReader, BufferedWriter)
* Multithreading (`Thread` class)

---

## 📁 Project Structure

```
StudentManagementSystem/
│
├── Main.java              # CLI interface
├── GUI.java               # GUI interface
├── Student.java           # Student class (model)
├── StudentManager.java    # Business logic
├── FileHandler.java       # File operations
├── AutoSaveThread.java    # Background auto-save thread
├── data.txt               # Data storage file
└── README.md              # Project documentation
```

---

## ⚙️ How to Run the Project

### 🔹 Step 1: Open Terminal

Navigate to the project folder:

```
cd StudentManagementSystem
```

---

### 🔹 Step 2: Compile the Project

```
javac *.java
```

---

### 🔹 Step 3: Run CLI Version

```
java Main
```

---

### 🔹 Step 4: Run GUI Version

```
java GUI
```

---

## 🖥️ CLI Execution (Step-by-Step)

1. Run `java Main`
2. Menu appears
3. Choose options (1–6)
4. Enter required inputs

---

### 📸 Screenshot 1: CLI Menu

![CLI Menu](screenshot\Screenshot 2026-03-31 000423.png)

---

### 📸 Screenshot 2: Add Student

![CLI Menu](screenshot\Screenshot 2026-03-31 000519.png)


---

### 📸 Screenshot 3: View Students

![CLI Menu](screenshot\Screenshot 2026-03-31 000558.png)


---

## 🪟 GUI Execution (Step-by-Step)

1. Run `java GUI`
2. GUI window opens
3. Enter student details
4. Use buttons (Add, Search, Update, Delete)

---

### 📸 Screenshot 4: GUI Window

![CLI Menu](screenshot\Screenshot 2026-03-31 000705.png)

---

### 📸 Screenshot 5: Add Student (GUI)

![CLI Menu](screenshot\Screenshot 2026-03-31 000817.png)


---

### 📸 Screenshot 6: Table Display

![CLI Menu](screenshot\Screenshot 2026-03-31 001017.png)


---

## 🔄 Multithreading Feature

The system uses a background thread (`AutoSaveThread`) to:

* Automatically save data every 5 seconds
* Prevent data loss
* Improve performance

---

## 🧠 Concepts Demonstrated

* Object-Oriented Programming (Encapsulation, Classes)
* Java Collections Framework
* File Handling (I/O Streams)
* Exception Handling
* Multithreading
* GUI Development using Swing

---

## 🎯 Real-World Application

This system can be used for:

* School/College student record management
* Basic database systems
* Learning Java application development

---

## ⚠️ Important Notes

* Project runs from command line (as required)
* Data is stored in `data.txt`
* GUI is optional but included for better usability

---

## 🚀 Future Enhancements

* Database integration using JDBC
* Login system
* Advanced UI design
* Sorting and filtering options

---

## 👨‍💻 Author

Developed as part of BYOP (Bring Your Own Project)

---
