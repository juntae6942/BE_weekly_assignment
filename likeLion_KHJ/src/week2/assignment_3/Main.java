package week2.assignment_3;

import java.util.ArrayList;
import java.util.List;

public class Main implements StudentManager{

    private List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void updateStudent(String name, double score) {
        for(Student st : studentList){
            if(st.getName().compareTo(name)==0){
                st.setScore(score);
            }
        }
    }

    @Override
    public void deleteStudent(String name) {
        for(int i=0;i< studentList.size();i++){
            if(studentList.get(i).getName().compareTo(name)==0){
                studentList.remove(i);
                break;
            }
        }
    }

    @Override
    public void printAllStudents() {
        for(Student st : studentList){
            System.out.printf("%s 학생의 점수는 %.2f점 입니다.\n",st.getName(),st.getScore());
        }
        System.out.println();
    }

    public static void main(String args[]){
        Main main = new Main();
        Student st1 = new Student("강영현", 100);
        main.addStudent(st1);
        Student st2 = new Student("최상엽", 95);
        main.addStudent(st2);
        Student st3 = new Student("신예찬", 77.7);
        main.addStudent(st3);
        Student st4 = new Student("윤도운", 50.4);
        main.addStudent(st4);
        Student st5 = new Student("이민호", 88.8);
        main.addStudent(st5);

        main.printAllStudents();


        // 점수 변경
        main.updateStudent("신예찬",100);
        main.printAllStudents();

        //기록 삭제
        main.deleteStudent("이민호");
        main.printAllStudents();
    }
}
