package Bai7.inteface_colorable.src;

interface Colorable {
    void howToColor();
}

abstract class ShapeColorable {
    private String color = "green";
    private boolean filled = true;

    public ShapeColorable() {
    }

    public ShapeColorable(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + (filled ? "filled" : "not filled") + "]";
    }
}

class Circle extends ShapeColorable {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle radius = " + radius;
    }
}

class Rectangle extends ShapeColorable {
    protected double width;
    protected double length;

    public Rectangle() {
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle width = " + width +
                ", length = " + length;
    }
}

class Square extends Rectangle implements Colorable {

    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    @Override
    public String toString() {
        return "Square side = " + width;
    }
}

public class MainColorable {
    public static void main(String[] args) {

        ShapeColorable[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Square(3),
                new Square(7)
        };

        for (ShapeColorable shape : shapes) {

            System.out.println(shape);
            System.out.println("Area = " + shape.getArea());

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println("----------------------");
        }
    }
}