package manage;
public class main {
    public static void main(String[] args) {
        deep d = new deep();
        d.addStudent(new Student(100.0,"이은경"));
        d.addStudent(new Student(90.0,"김민지"));
        d.addStudent(new Student(80.0,"이다은"));
        d.addStudent(new Student(50.0,"김민성"));
        d.addStudent(new Student(80.0,"임영우"));
        d.addStudent(new Student(75.0,"우정현"));
        d.printAllStudent();
        System.out.println();

        d.updateStudent("김민성",100.0);
        d.printAllStudent();
        System.out.println();

        d.deleteStudent("이은경");
        d.printAllStudent();
    }
}
