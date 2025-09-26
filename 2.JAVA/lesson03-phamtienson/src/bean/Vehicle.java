package bean;

public class Vehicle {
    private String name;
    private String model;
    private int engineCapacity;
    private double price;

    public Vehicle(String name, String model, int engineCapacity, double price) {
        this.name = name;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.price = price;
    }

    public double calculateTax() {
        if (engineCapacity < 100) {
            return 0.01 * price;
        } else if (engineCapacity <= 200) {
            return 0.03 * price;
        } else {
            return 0.05 * price;
        }
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10d %-15.2f %-15.2f",
                name, model, engineCapacity, price, calculateTax());
    }

}