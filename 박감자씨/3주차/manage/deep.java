package manage;
import java.util.HashMap;
import java.util.Set;

public class deep implements studentManager {
    HashMap<String, Student> map = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        map.put(student.getName(), student);
    }
    @Override
    public void updateStudent(String name, double score) {
        Student tmp = map.get(name);
        tmp.setPoint(score);
        map.put(name, tmp);
    }

    @Override
    public void deleteStudent(String name) {
        map.remove(name);
    }

    @Override
    public void printAllStudent() {
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + " 학생의 점수는 " + map.get(s).getPoint() + "점 입니다.");
        }
    }
}
