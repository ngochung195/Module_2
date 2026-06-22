class Circle {
    private double radius = 1.0;
    private String color = "blue";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + ", area=" + String.format("%.2f", getArea()) + "]";
    }
}

public class CircleTest {
    public static void main(String[] args) {
        System.out.println("Kiem thu lop Circle");

        Circle c1 = new Circle();
        System.out.println(c1);

        Circle c2 = new Circle(2.5, "red");
        System.out.println(c2);

        c2.setRadius(3);
        c2.setColor("green");
        System.out.println("Sau khi thay doi: " + c2);
    }

}