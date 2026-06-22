class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
        super();
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[] { getX(), getY(), z };
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}

public class Point3DTest {
    public static void main(String[] args) {
        System.out.println("KIEM THU LOP POINT3D");

        Point3D p3a = new Point3D();
        System.out.println("Toa do ban dau: " + p3a);

        Point3D p3b = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Toa do: " + p3b);

        p3b.setXYZ(7.5f, 8.5f, 9.5f);
        System.out.println("Sau khi doi setXYZ(): " + p3b);

        float[] xyz = p3b.getXYZ();
        System.out.println("Mang lay tu getXYZ(): {" + xyz[0] + ", " + xyz[1] + ", " + xyz[2] + "}");
    }

}
