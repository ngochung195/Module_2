package Bai4.Fan.src;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10.0);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println("Thông tin Fan 1:");
        System.out.println(fan1.toString());

        System.out.println("\nThông tin Fan 2:");
        System.out.println(fan2.toString());
    }
}
