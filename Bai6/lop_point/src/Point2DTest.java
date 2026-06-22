class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
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

    public float[] getXY() {
        return new float[] { x, y };
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class Point2DTest {
    public static void main(String[] args) {
        System.out.println("KIEM THU LOP POINT2D");

        Point2D p2a = new Point2D();
        System.out.println("Toa do ban dau: " + p2a);

        Point2D p2b = new Point2D(1.5f, 2.5f);
        System.out.println("Toa do: " + p2b);

        p2b.setXY(4.0f, 6.0f);
        System.out.println("Sau khi setXY: " + p2b);

        float[] xy = p2b.getXY();
        System.out.println("Mang lay ra tu getXY(): {" + xy[0] + ", " + xy[1] + "}");
    }
}