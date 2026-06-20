/**
 * HỆ THỐNG TÍNH LƯƠNG TECHCORP
 */
package Bai6.tech_corp;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double baseSalary;

    public FullTimeEmployee(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private static final double HOURLY_RATE = 100000;

    public PartTimeEmployee(String name, int workingHours) {
        super(name);
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return workingHours * HOURLY_RATE;
    }
}

class InternEmployee extends Employee {
    private static final double FIXED_STIPEND = 3000000;

    public InternEmployee(String name) {
        super(name);
    }

    @Override
    public double calculateSalary() {
        return FIXED_STIPEND;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {

        Employee[] empList = {
                new FullTimeEmployee("Alice", 20000000),
                new PartTimeEmployee("Bob", 45),
                new InternEmployee("Charlie")
        };

        System.out.println("--- BANG LUONG THANG NAY ---");

        for (Employee emp : empList) {
            System.out.printf("Nhan vien: %-10s | Luong: %,.0f VND%n", emp.getName(), emp.calculateSalary());
        }
    }
}