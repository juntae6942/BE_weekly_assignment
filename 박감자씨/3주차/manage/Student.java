package manage;
public class Student {
        double point;
        String name;

        public Student(double point, String name) {
            this.point = point;
            this.name = name;
        }

        public double getPoint() {
            return point;
        }

        public void setPoint(double point) {
            this.point = point;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
}