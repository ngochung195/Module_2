class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height
                + ", volume=" + String.format("%.2f", getVolume()) + "]";
    }
}

public class CylinderTest {
    public static void main(String[] args) {
        System.out.println("Kiem thu lop Cylender");

        Cylinder cy1 = new Cylinder();
        System.out.println(cy1);

        Cylinder cy2 = new Cylinder(2.0, 5.0, "yellow");
        System.out.println(cy2);

        cy2.setRadius(3.5);
        cy2.setHeight(10.0);
        cy2.setColor("purple");

        System.out.println("Sau khi thay đổi: " + cy2);
    }
}
