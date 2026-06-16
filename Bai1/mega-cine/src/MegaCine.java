public class MegaCine {

    // HÀM 1: LEGACY CODE CŨ
    public double calculatePriceLegacy(int age, String dayOfWeek, boolean isMember) {
        double basePrice = 100000;
        double finalPrice = 0;

        if (age > 0) {
            if (dayOfWeek != null && !dayOfWeek.isEmpty()) {
                if (dayOfWeek.equalsIgnoreCase("Tuesday")) {
                    finalPrice = basePrice * 0.5;
                } else {
                    if (age <= 12) {
                        if (isMember) {
                            finalPrice = (basePrice * 0.7) - 10000;
                        } else {
                            finalPrice = basePrice * 0.7;
                        }
                    } else if (age >= 60) {
                        finalPrice = basePrice * 0.6;
                    } else {
                        if (dayOfWeek.equalsIgnoreCase("Saturday") || dayOfWeek.equalsIgnoreCase("Sunday")) {
                            if (isMember) {
                                finalPrice = (basePrice * 1.2) * 0.9;
                            } else {
                                finalPrice = basePrice * 1.2;
                            }
                        } else {
                            if (isMember) {
                                finalPrice = basePrice * 0.9;
                            } else {
                                finalPrice = basePrice;
                            }
                        }
                    }
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
        return finalPrice;
    }

    // HÀM 2: REFACTORED CODE MỚI
    public double calculatePriceRefactored(int age, String dayOfWeek, boolean isMember) {
        double basePrice = 100000;

        if (age <= 0)
            return -1;
        if (dayOfWeek == null || dayOfWeek.trim().isEmpty())
            return -1;

        if (dayOfWeek.equalsIgnoreCase("Tuesday")) {
            return basePrice * 0.5;
        }

        if (age <= 12) {
            double childPrice = basePrice * 0.7;
            return isMember ? childPrice - 10000 : childPrice;
        }
        if (age >= 60) {
            return basePrice * 0.6;
        }

        double dayMultiplier = switch (dayOfWeek.toLowerCase()) {
            case "saturday", "sunday" -> 1.2;
            default -> 1.0;
        };

        double finalPrice = basePrice * dayMultiplier;
        return isMember ? finalPrice * 0.9 : finalPrice;
    }

    public static void main(String[] args) {
        MegaCine cine = new MegaCine();

        System.out.println("=== KẾT QUẢ SO SÁNH ===");

        // Test case 1
        System.out.println("\n[Test 1] Tham so: (-5, \"Monday\", true)");
        System.out.println("-> Legacy: " + cine.calculatePriceLegacy(-5, "Monday", true));
        System.out.println("-> Refactored: " + cine.calculatePriceRefactored(-5, "Monday", true));

        // Test case 2
        System.out.println("\n[Test 2] Tham so: (10, \"Tuesday\", false)");
        System.out.println("-> Legacy: " + cine.calculatePriceLegacy(10, "Tuesday", false));
        System.out.println("-> Refactored: " + cine.calculatePriceRefactored(10, "Tuesday", false));

        // Test case 3
        System.out.println("\n[Test 3] Tham so: (25, \"Sunday\", true)");
        System.out.println("-> Legacy: " + cine.calculatePriceLegacy(25, "Sunday", true));
        System.out.println("-> Refactored: " + cine.calculatePriceRefactored(25, "Sunday", true));

        // Test case 4
        System.out.println("\n[Test 4] Tham so: (65, \"Friday\", false)");
        System.out.println("-> Legacy: " + cine.calculatePriceLegacy(65, "Friday", false));
        System.out.println("-> Refactored: " + cine.calculatePriceRefactored(65, "Friday", false));
    }
}