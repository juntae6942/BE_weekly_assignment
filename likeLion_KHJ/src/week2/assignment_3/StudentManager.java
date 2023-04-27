package week2.assignment_3;

public interface StudentManager {
    void addStudent(Student student);
    void updateStudent(String name, double score);
    void deleteStudent(String name);
    void printAllStudents();
}
