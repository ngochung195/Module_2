public class TriangleClassifier {
    public static String getTriangleClassifier(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return "Không phải là tam giác";
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Không phải là tam giác";
        }

        if (a == b && b == c) {
            return "Tam giác đều";
        }

        if (a == b || a == c || b == c) {
            return "Tam giác cân";
        }

        return "Tam giác thường";
    }
}