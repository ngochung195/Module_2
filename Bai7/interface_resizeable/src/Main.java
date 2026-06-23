interface Resizeable {
    void resize(double percent);
}

class Circle implements Resizeable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void resize(double percent) {
        radius += radius * percent / 100;
    }

    @Override
    public String toString() {
        return "Circle radius = " + radius;
    }
}

class Rectangle implements Resizeable {
    protected double width;
    protected double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    @Override
    public void resize(double percent) {
        width += width * percent / 100;
        length += length * percent / 100;
    }

    @Override
    public String toString() {
        return "Rectangle width = " + width + ", length = " + length;
    }
}

class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public void resize(double percent) {
        width += width * percent / 100;
        length = width;
    }

    @Override
    public String toString() {
        return "Square side = " + width;
    }
}

public class Main {
    public static void main(String[] args) {

        Resizeable[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Square(5)
        };

        for (Resizeable shape : shapes) {

            double oldArea = 0;

            if (shape instanceof Circle) {
                oldArea = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                oldArea = ((Rectangle) shape).getArea();
            }

            double percent = Math.random() * 100 + 1;

            System.out.println("Tăng kích thước: " +
                    String.format("%.2f", percent) + "%");

            shape.resize(percent);

            double newArea = 0;

            if (shape instanceof Circle) {
                newArea = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                newArea = ((Rectangle) shape).getArea();
            }

            System.out.println("Diện tích trước: " +
                    String.format("%.2f", oldArea));
            System.out.println("Diện tích sau: " +
                    String.format("%.2f", newArea));
            System.out.println("--------------------");
        }
    }
}