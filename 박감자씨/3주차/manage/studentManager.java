package manage;
public interface studentManager {
    void addStudent(Student student);

    void updateStudent(String name, double score);

    void deleteStudent(String name);

    void printAllStudent();
}
