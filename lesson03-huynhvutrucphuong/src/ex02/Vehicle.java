package ex02;

public class Vehicle {
    private String owner;
    private String vehicleName;
    private double value;   
    private int capacity;   

    public Vehicle() {}

    public Vehicle(String owner, String vehicleName, double value, int capacity) {
        this.owner = owner;
        this.vehicleName = vehicleName;
        this.value = value;
        this.capacity = capacity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Tính thuế trước bạ
    public double getTax() {
        if (capacity < 100) {
            return value * 0.01;
        } else if (capacity <= 200) {
            return value * 0.03;
        } else {
            return value * 0.05;
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %10.2f %10d %10.2f",
                owner, vehicleName, value, capacity, getTax());
    }

   
}
