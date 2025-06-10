import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SchoolManagementGUI extends JFrame {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    
    private JTextArea outputArea = new JTextArea(10, 40);

    public SchoolManagementGUI() {
        setTitle("School Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3, 10, 10));

        JButton addStudentBtn = new JButton("Add Student");
        JButton addTeacherBtn = new JButton("Add Teacher");
        JButton viewStudentsBtn = new JButton("View Students");
        JButton viewTeachersBtn = new JButton("View Teachers");
        JButton clearBtn = new JButton("Clear Output");
        JButton exitBtn = new JButton("Exit");

        panel.add(addStudentBtn);
        panel.add(addTeacherBtn);
        panel.add(viewStudentsBtn);
        panel.add(viewTeachersBtn);
        panel.add(clearBtn);
        panel.add(exitBtn);

        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event Listeners
        addStudentBtn.addActionListener(e -> addStudent());
        addTeacherBtn.addActionListener(e -> addTeacher());
        viewStudentsBtn.addActionListener(e -> viewStudents());
        viewTeachersBtn.addActionListener(e -> viewTeachers());
        clearBtn.addActionListener(e -> outputArea.setText(""));
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Student ID:"));
            String name = JOptionPane.showInputDialog(this, "Enter Student Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Student Age:"));
            String grade = JOptionPane.showInputDialog(this, "Enter Student Grade:");

            students.add(new Student(id, name, age, grade));
            outputArea.append("✅ Student added successfully.\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addTeacher() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Teacher ID:"));
            String name = JOptionPane.showInputDialog(this, "Enter Teacher Name:");
            String subject = JOptionPane.showInputDialog(this, "Enter Subject:");

            teachers.add(new Teacher(id, name, subject));
            outputArea.append("✅ Teacher added successfully.\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            outputArea.append("No students registered.\n");
        } else {
            outputArea.append("--- List of Students ---\n");
            for (Student s : students) {
                outputArea.append(s + "\n");
            }
        }
    }

    private void viewTeachers() {
        if (teachers.isEmpty()) {
            outputArea.append("No teachers registered.\n");
        } else {
            outputArea.append("--- List of Teachers ---\n");
            for (Teacher t : teachers) {
                outputArea.append(t + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SchoolManagementGUI().setVisible(true);
        });
    }
}