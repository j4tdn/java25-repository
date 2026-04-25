package bean;

public class Trader {
    private int id;
    private String name;
    private String city;

    public Trader(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return "Trader [Ten=" + name + ", Thanh pho=" + city + "]";
    }
}