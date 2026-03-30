import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        manager.setStudents(FileHandler.loadFromFile());

       while (true) {
    System.out.println("\n===== Student Management System =====");
    System.out.println("1. Add Student");
    System.out.println("2. View Students");
    System.out.println("3. Search Student (Enter ID)");
    System.out.println("4. Update Student (Enter ID + details)");
    System.out.println("5. Delete Student (Enter ID)");
    System.out.println("6. Exit");
    System.out.print("Enter your choice: ");

    String input = sc.nextLine().trim();
    int choice;

    try {
        choice = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        System.out.println("❌ Invalid input! Please enter a number (1–6).");
        continue;
    }

    switch (choice) {

        case 1:
            try {
                System.out.println("👉 Enter student details:");

                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());

                if (manager.searchStudent(id) != null) {
                    System.out.println("❌ ID already exists!");
                    break;
                }

                System.out.print("Name: ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("❌ Name cannot be empty!");
                    break;
                }

                System.out.print("Age: ");
                int age = Integer.parseInt(sc.nextLine());
                if (age <= 0) {
                    System.out.println("❌ Age must be positive!");
                    break;
                }

                System.out.print("Course: ");
                String course = sc.nextLine().trim();
                if (course.isEmpty()) {
                    System.out.println("❌ Course cannot be empty!");
                    break;
                }

                manager.addStudent(new Student(id, name, age, course));

            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter correct data.");
            }
            break;

        case 2:
            System.out.println("📄 Displaying all student records:");
            manager.viewStudents();
            break;

        case 3:
            try {
                System.out.print("👉 Enter Student ID to search: ");
                int id = Integer.parseInt(sc.nextLine());

                Student s = manager.searchStudent(id);
                if (s != null) {
                    System.out.println("✅ Student Found:");
                    System.out.println("ID: " + s.getId() +
                            ", Name: " + s.getName() +
                            ", Age: " + s.getAge() +
                            ", Course: " + s.getCourse());
                } else {
                    System.out.println("❌ Student not found.");
                }

            } catch (Exception e) {
                System.out.println("❌ Invalid ID!");
            }
            break;

        case 4:
            try {
                System.out.print("👉 Enter ID to update: ");
                int id = Integer.parseInt(sc.nextLine());

                if (manager.searchStudent(id) == null) {
                    System.out.println("❌ Student not found!");
                    break;
                }

                System.out.print("New Name: ");
                String name = sc.nextLine();

                System.out.print("New Age: ");
                int age = Integer.parseInt(sc.nextLine());

                System.out.print("New Course: ");
                String course = sc.nextLine();

                manager.updateStudent(id, name, age, course);

            } catch (Exception e) {
                System.out.println("❌ Invalid input!");
            }
            break;

        case 5:
            try {
                System.out.print("👉 Enter ID to delete: ");
                int id = Integer.parseInt(sc.nextLine());

                if (manager.searchStudent(id) == null) {
                    System.out.println("❌ Student not found!");
                    break;
                }

                System.out.print("Are you sure? (y/n): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("y")) {
                    manager.deleteStudent(id);
                } else {
                    System.out.println("❌ Deletion cancelled.");
                }

            } catch (Exception e) {
                System.out.println("❌ Invalid ID!");
            }
            break;

        case 6:
            FileHandler.saveToFile(manager.getStudents());
            System.out.println("💾 Data Saved. Exiting...");
            return;

    default:
        System.out.println("❌ Invalid choice! Enter 1–6.");
    }
    }
    }
}