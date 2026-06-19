package Bai5.access_modifier2.src;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();

        System.out.println("Trang thai ban dau");
        student.display();

        student.setName("Alice");
        student.setClasses("CodeGym");

        System.out.println("Trang thai sau thay doi");
        student.display();
    }
}
