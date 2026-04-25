package bean;

import java.util.Objects;

public class Trader {
    private int id;
    private String name;
    private String city;
    
    public Trader() {
	}
    

    public Trader(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trader trader)) return false;
        return id == trader.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Trader{id=" + id + ", name='" + name + "', city='" + city + "'}";
    }
}