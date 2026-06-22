class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[] { x, y };
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
        super();
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[] { xSpeed, ySpeed };
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY()
                + "), speed = (" + xSpeed + ", " + ySpeed + ")";
    }

    public MovablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }
}

public class PointTest {
    public static void main(String[] args) {
        System.out.println("----- KIEM THU LOP POINT -----");

        Point p1 = new Point();
        System.out.println("Diem p1 (mac dinh): " + p1);

        Point p2 = new Point(3.5f, 4.5f);
        System.out.println("Diem p2 (khoi tao): " + p2);

        p2.setXY(10.0f, 20.0f);
        System.out.println("Diem p2 sau khi setXY: " + p2);

        float[] toaDoP2 = p2.getXY();
        System.out.println("Lay mang tu p2: [" + toaDoP2[0] + ", " + toaDoP2[1] + "]");

        System.out.println("\n----- KIEM THU LOP MOVABLEPOINT -----");

        MovablePoint mp = new MovablePoint(1.0f, 2.0f, 1.5f, 2.5f);
        System.out.println("Trang thai ban dau: " + mp);

        mp.move();
        System.out.println("Sau khi di chuyen lan 1: " + mp);

        mp.move();
        System.out.println("Sau khi di chuyen lan 2: " + mp);

        mp.setSpeed(5.0f, -1.0f);
        System.out.println("Sau khi doi toc do moi: " + mp);

        mp.move().move();
        System.out.println("Sau khi di chuyen them 2 lan voi toc do moi: " + mp);
    }
}
