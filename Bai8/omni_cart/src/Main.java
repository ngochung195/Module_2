/**
 * HỆ THỐNG THANH TOÁN OMNICART (LEGACY CODE)
 */
class LegacyCheckoutService {

    // Hàm xử lý kềnh càng, tên biến viết tắt tối nghĩa
    public double processOrder(String cType, double amt, int iType) {
        double fPrice = 0;

        // Smell 1: Lồng ghép quá sâu (Arrow Anti-Pattern)
        if (amt > 0) {
            if (cType != null && !cType.isEmpty()) {
                // Smell 2: Magic Numbers (1, 2 là gì? Không ai biết)
                if (iType == 1) {
                    double d = 0;
                    if (cType.equals("VIP")) {
                        if (amt > 5000000) {
                            d = amt * 0.15; // 0.15 là gì?
                        } else {
                            d = amt * 0.10;
                        }
                    } else {
                        d = amt * 0.05;
                    }
                    // Smell 3: Tính toán gộp phức tạp, thiếu chú thích ý nghĩa
                    fPrice = (amt - d) * 1.10 + 50000;
                } else if (iType == 2) {
                    double d = (cType.equals("VIP")) ? amt * 0.08 : 0;
                    fPrice = (amt - d) * 1.05 + 20000;
                }
            } else {
                System.out.println("Invalid Customer");
                return -1;
            }
        } else {
            System.out.println("Invalid Amount");
            return -1;
        }

        return fPrice;
    }
}

class CheckoutService {

    private static final int ITEM_ELECTRONICS = 1;
    private static final int ITEM_FASHION = 2;

    private static final String CUSTOMER_VIP = "VIP";

    private static final double VIP_THRESHOLD = 5_000_000;

    private static final double VIP_ELECTRONICS_DISCOUNT = 0.15;
    private static final double VIP_ELECTRONICS_NORMAL_DISCOUNT = 0.10;
    private static final double REGULAR_ELECTRONICS_DISCOUNT = 0.05;

    private static final double VIP_FASHION_DISCOUNT = 0.08;

    private static final double ELECTRONICS_TAX_RATE = 1.10;
    private static final double FASHION_TAX_RATE = 1.05;

    private static final double ELECTRONICS_SHIPPING_FEE = 50_000;
    private static final double FASHION_SHIPPING_FEE = 20_000;

    public double processOrder(String customerType,
            double orderAmount,
            int itemType) {

        if (orderAmount <= 0) {
            System.out.println("Invalid Amount");
            return -1;
        }

        if (customerType == null || customerType.isEmpty()) {
            System.out.println("Invalid Customer");
            return -1;
        }

        double discountAmount = calculateDiscount(customerType, orderAmount, itemType);

        return calculateFinalPrice(orderAmount,
                discountAmount,
                itemType);
    }

    private double calculateDiscount(String customerType,
            double orderAmount,
            int itemType) {

        if (itemType == ITEM_ELECTRONICS) {
            return calculateElectronicsDiscount(customerType, orderAmount);
        }

        if (itemType == ITEM_FASHION) {
            return calculateFashionDiscount(customerType, orderAmount);
        }

        return 0;
    }

    private double calculateElectronicsDiscount(String customerType,
            double orderAmount) {

        if (CUSTOMER_VIP.equals(customerType)) {

            if (orderAmount > VIP_THRESHOLD) {
                return orderAmount * VIP_ELECTRONICS_DISCOUNT;
            }

            return orderAmount * VIP_ELECTRONICS_NORMAL_DISCOUNT;
        }

        return orderAmount * REGULAR_ELECTRONICS_DISCOUNT;
    }

    private double calculateFashionDiscount(String customerType,
            double orderAmount) {

        if (CUSTOMER_VIP.equals(customerType)) {
            return orderAmount * VIP_FASHION_DISCOUNT;
        }

        return 0;
    }

    private double calculateFinalPrice(double orderAmount,
            double discountAmount,
            int itemType) {

        if (itemType == ITEM_ELECTRONICS) {
            return (orderAmount - discountAmount)
                    * ELECTRONICS_TAX_RATE
                    + ELECTRONICS_SHIPPING_FEE;
        }

        if (itemType == ITEM_FASHION) {
            return (orderAmount - discountAmount)
                    * FASHION_TAX_RATE
                    + FASHION_SHIPPING_FEE;
        }

        return 0;
    }
}

public class Main {

    public static void main(String[] args) {

        LegacyCheckoutService legacy = new LegacyCheckoutService();

        CheckoutService refactored = new CheckoutService();

        runTest(legacy, refactored, "VIP", 6000000, 1);

        runTest(legacy, refactored, "VIP", 3000000, 1);

        runTest(legacy, refactored, "NORMAL", 3000000, 1);

        runTest(legacy, refactored, "VIP", 2000000, 2);

        runTest(legacy, refactored, "NORMAL", 2000000, 2);

        runTest(legacy, refactored, "", 2000000, 2);

        runTest(legacy, refactored, "VIP", -1000, 1);
    }

    private static void runTest(
            LegacyCheckoutService legacy,
            CheckoutService refactored,
            String customerType,
            double orderAmount,
            int itemType) {

        double oldResult = legacy.processOrder(
                customerType,
                orderAmount,
                itemType);

        double newResult = refactored.processOrder(
                customerType,
                orderAmount,
                itemType);

        System.out.println("--------------------------------");

        System.out.println(
                "Input: "
                        + customerType + ", "
                        + orderAmount + ", "
                        + itemType);

        System.out.println("Legacy     = " + oldResult);

        System.out.println("Refactored = " + newResult);

        System.out.println(
                "Match = "
                        + (Double.compare(oldResult,
                                newResult) == 0));
    }
}