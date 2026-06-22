import java.util.ArrayList;
import java.util.List;

abstract class Transport {
    protected double baseWeight;
    protected double distance;

    public Transport(double baseWeight, double distance) {
        this.baseWeight = baseWeight;
        this.distance = distance;
    }

    public abstract double calculateCost();
}

class TruckTransport extends Transport {
    private double tollFee;

    public TruckTransport(double baseWeight, double distance, double tollFee) {
        super(baseWeight, distance);
        this.tollFee = tollFee;
    }

    @Override
    public double calculateCost() {
        return (baseWeight * 1.5) + (distance * 2.0) + tollFee;
    }
}

class ShipTransport extends Transport {
    private double portSurcharge;

    public ShipTransport(double baseWeight, double distance, double portSurcharge) {
        super(baseWeight, distance);
        this.portSurcharge = portSurcharge;
    }

    @Override
    public double calculateCost() {
        return (baseWeight * 0.8) + (distance * 1.0) + portSurcharge;
    }
}

class AirTransport extends Transport {
    private double flightInsurance;

    public AirTransport(double baseWeight, double distance, double flightInsurance) {
        super(baseWeight, distance);
        this.flightInsurance = flightInsurance;
    }

    @Override
    public double calculateCost() {
        return (baseWeight * 5.0) + (distance * 4.0) + flightInsurance;
    }
}

public class FreightSystem {
    public static void main(String[] args) {
        List<Transport> orders = new ArrayList<>();

        orders.add(new TruckTransport(100.0, 50.0, 15.0));
        orders.add(new AirTransport(50.0, 1000.0, 200.0));
        orders.add(new ShipTransport(500.0, 300.0, 120.0));

        double totalRevenue = 0;

        System.out.println("--- CHI TIET CUOC PHI TUNG DON HANG ---");
        for (Transport order : orders) {
            double cost = order.calculateCost();

            System.out.println("Loai hinh: " + order.getClass().getSimpleName() + " - Cuoc phi: $" + cost);

            totalRevenue += cost;
        }

        System.out.println("\n------------------------------------");
        System.out.println("Tong cuoc phi thu duoc: $" + totalRevenue);
    }
}