public class TriangleClassifier {

    public static String getTriangleClassifier(int sideA, int sideB, int sideC) {

        if (isInvalidTriangle(sideA, sideB, sideC)) {
            return "Không phải là tam giác";
        }

        if (isEquilateral(sideA, sideB, sideC)) {
            return "Tam giác đều";
        }

        if (isIsosceles(sideA, sideB, sideC)) {
            return "Tam giác cân";
        }

        return "Tam giác thường";
    }

    private static boolean isInvalidTriangle(int sideA, int sideB, int sideC) {
        return sideA <= 0 || sideB <= 0 || sideC <= 0
                || !isValidTriangle(sideA, sideB, sideC);
    }

    private static boolean isValidTriangle(int sideA, int sideB, int sideC) {
        return sideA + sideB > sideC
                && sideA + sideC > sideB
                && sideB + sideC > sideA;
    }

    private static boolean isEquilateral(int sideA, int sideB, int sideC) {
        return sideA == sideB && sideB == sideC;
    }

    private static boolean isIsosceles(int sideA, int sideB, int sideC) {
        return sideA == sideB || sideA == sideC || sideB == sideC;
    }
}