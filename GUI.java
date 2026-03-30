import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUI extends JFrame {

    private JTextField idField, nameField, ageField, courseField;
    private JTable table;
    private DefaultTableModel model;
    private StudentManager manager;

    public GUI() {
        manager = new StudentManager();
        manager.setStudents(FileHandler.loadFromFile());
        
        AutoSaveThread autoSave = new AutoSaveThread(manager);
        autoSave.setDaemon(true); // runs in background
        autoSave.start(); 

        setTitle("Student Management System");
        setSize(700, 500);
        setLocationRelativeTo(null); // center screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MAIN PANEL
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        formPanel.add(courseField);

        panel.add(formPanel, BorderLayout.NORTH);

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Course"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        // ===== BUTTON PANEL =====
        JPanel btnPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        JButton addBtn = new JButton("Add");
        JButton viewBtn = new JButton("Refresh");
        JButton searchBtn = new JButton("Search");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton clearBtn = new JButton("Clear");

        btnPanel.add(addBtn);
        btnPanel.add(viewBtn);
        btnPanel.add(searchBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(clearBtn);

        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel);

        // ===== BUTTON ACTIONS =====

        // ADD
        addBtn.addActionListener(e -> {
     try {
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() ||
            ageField.getText().isEmpty() || courseField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        int id = Integer.parseInt(idField.getText());
        int age = Integer.parseInt(ageField.getText());

        if (age <= 0) {
            JOptionPane.showMessageDialog(this, "Age must be positive!");
            return;
        }

        // duplicate check
        if (manager.searchStudent(id) != null) {
            JOptionPane.showMessageDialog(this, "ID already exists!");
            return;
        }

         manager.addStudent(new Student(id, nameField.getText(), age, courseField.getText()));
         FileHandler.saveToFile(manager.getStudents());

         refreshTable();
         JOptionPane.showMessageDialog(this, "Student Added Successfully!");

        } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this, "ID and Age must be numbers!");
        }
     });
        // REFRESH
       viewBtn.addActionListener(e -> {
       refreshTable();
       JOptionPane.showMessageDialog(this, "Displaying all student records.");
     });

        // SEARCH
        searchBtn.addActionListener(e -> {
     try {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter ID to search!");
            return;
        }

        int id = Integer.parseInt(idField.getText());
        Student s = manager.searchStudent(id);

        if (s != null) {
            nameField.setText(s.getName());
            ageField.setText(String.valueOf(s.getAge()));
            courseField.setText(s.getCourse());
            JOptionPane.showMessageDialog(this, "Student Found!");
        } else {
            JOptionPane.showMessageDialog(this, "Student Not Found!");
        }

        } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this, "Enter valid numeric ID!");
        }
        });
        // UPDATE
       updateBtn.addActionListener(e -> {
     try {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter ID to update!");
            return;
        }

        int id = Integer.parseInt(idField.getText());
        int age = Integer.parseInt(ageField.getText());

        if (nameField.getText().isEmpty() || courseField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields!");
            return;
        }

        manager.updateStudent(id, nameField.getText(), age, courseField.getText());
        FileHandler.saveToFile(manager.getStudents());

        refreshTable();
        JOptionPane.showMessageDialog(this, "Student Updated!");

        } catch (Exception ex) {
         JOptionPane.showMessageDialog(this, "Invalid Input!");
        }
     });

        // DELETE
       deleteBtn.addActionListener(e -> {
     try {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter ID to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?");
        if (confirm != JOptionPane.YES_OPTION) return;

        int id = Integer.parseInt(idField.getText());

        manager.deleteStudent(id);
        FileHandler.saveToFile(manager.getStudents());

        refreshTable();
        JOptionPane.showMessageDialog(this, "Student Deleted!");

       } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this, "Enter valid ID!");
       }
     });
        // CLEAR
        clearBtn.addActionListener(e -> {
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            courseField.setText("");
        });

        setVisible(true);
    }

    // TABLE REFRESH METHOD
    private void refreshTable() {
        model.setRowCount(0);

        for (Student s : manager.getStudents()) {
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getAge(),
                    s.getCourse()
            });
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}