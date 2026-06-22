import java.util.Scanner;

class Shape {
    private String color = "green";

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}

class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
        super();
    }

    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Triangle[" + super.toString() + ", side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
    }
}

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- CHUONG TRINH KIEM THU TAM GIAC ---");

        System.out.print("Nhap vao do dai canh thu nhat: ");
        double s1 = scanner.nextDouble();

        System.out.print("Nhap vao do dai canh thu hai: ");
        double s2 = scanner.nextDouble();

        System.out.print("Nhap vao do dai canh thu ba: ");
        double s3 = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Nhap vao mau sac cua tam giac: ");
        String mauSac = scanner.nextLine();

        if ((s1 + s2 > s3) && (s1 + s3 > s2) && (s2 + s3 > s1)) {
            Triangle tamGiac = new Triangle(s1, s2, s3);
            tamGiac.setColor(mauSac);

            System.out.println("\n--- THONG TIN TAM GIAC ---");
            System.out.println("Thong tin chi tiet: " + tamGiac.toString());
            System.out.println("Mau sac: " + tamGiac.getColor());
            System.out.println("Chu vi: " + tamGiac.getPerimeter());
            System.out.println("Dien tich: " + String.format("%.2f", tamGiac.getArea()));
        } else {
            System.out.println("\nBa canh vua nhap khong tao thanh mot tam giac hop le!");
        }

        scanner.close();
    }
}