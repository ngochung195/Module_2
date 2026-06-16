class FuelConfig {
    public double getBasePrice() {
        return 22500.0;
    }
}

public class SpeedyLogis {

    // Ham gia lap tinh toan thue rat nang (mat thoi gian CPU)
    private double calculateHeavyTaxRate() {
        double tax = 1.0;
        for (int i = 0; i < 1000; i++) {
            tax += Math.sin(i) * Math.cos(i);
        }
        return 1.1 + (tax * 0); // Tra ve 1.1 (10% tax) nhung co tinh lam ton CPU
    }

    // --- CODE CŨ ---
    public double calculateRouteCost(double[] distances, double maxBudget) {
        double totalCost = 0;
        System.out.println("Bat dau tinh toan lo trinh (cu)...");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < distances.length; i++) {
            FuelConfig config = new FuelConfig();
            double currentTax = calculateHeavyTaxRate();
            double stepCost = distances[i] * config.getBasePrice() * currentTax;
            totalCost += stepCost;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay (cu): " + (endTime - startTime) + " ms");
        return totalCost;
    }

    // --- CODE MỚI ---
    public double calculateRouteCostOptimized(double[] distances, double maxBudget) {
        double totalCost = 0;

        System.out.println("Bat dau tinh toan lo trinh (moi)...");
        long startTime = System.currentTimeMillis();

        FuelConfig config = new FuelConfig();
        double basePrice = config.getBasePrice();
        double currentTax = calculateHeavyTaxRate();

        for (int i = 0; i < distances.length; i++) {
            double stepCost = distances[i] * basePrice * currentTax;
            totalCost += stepCost;

            if (totalCost > maxBudget) {
                System.out.println(
                        "CANH BAO: Chi phi lo trinh da vuot qua maxBudget (" + maxBudget + ") tai vi tri thu " + i);
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay (moi): " + (endTime - startTime) + " ms");

        return totalCost;
    }
}