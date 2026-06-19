package Bai5.access_modifier.src;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("--- Hình tròn 1 (Mặc định) ---");
        System.out.println("Bán kính: " + c1.getRadius());
        System.out.println("Diện tích: " + c1.getArea());

        Circle c2 = new Circle(2.5);
        System.out.println("\n--- Hình tròn 2 (Tùy chỉnh) ---");
        System.out.println("Bán kính: " + c2.getRadius());
        System.out.println("Diện tích: " + c2.getArea());
    }
}
