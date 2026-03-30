import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
    for (Student existing : students) {
        if (existing.getId() == s.getId()) {
            System.out.println("❌ Student ID already exists!");
            return;
        }
    }
    students.add(s);
    System.out.println("✅ Student Added Successfully!");
}
    public void viewStudents() {
    if (students.isEmpty()) {
        System.out.println("No records found.");
        return;
    }

    System.out.println("--------------------------------------------------");
    System.out.printf("%-6s %-15s %-6s %-10s\n", "ID", "Name", "Age", "Course");
    System.out.println("--------------------------------------------------");

    for (Student s : students) {
        System.out.printf("%-6d %-15s %-6d %-10s\n",
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getCourse());
    }

    System.out.println("--------------------------------------------------");
}

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        System.out.println("Student Deleted.");
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student s = searchStudent(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            System.out.println("Student Updated.");
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> list) {
        students = list;
    }
}