public class Student {
    int id, age;
    String name, grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Grade: " + grade;
    }
}