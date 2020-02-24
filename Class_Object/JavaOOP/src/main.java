import OOP.Student;

public class main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("Name:" + student.getName());
        System.out.println("Gender:" + student.getGender());
        System.out.println("Age:" + student.getAge());
        System.out.println("ID:" + student.getID());
    }
}