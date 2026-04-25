public class Transaction {
    private int id;
    private Trader trader;
    private String createdItem;
    private int value;
    private int year;


    public Transaction(int id, Trader trader, String createdItem, int value, int year) {
        this.id = id;
        this.trader = trader;
        this.createdItem = createdItem;
        this.value = value;
        this.year = year;
    }

 
    public int getId() {
        return id;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getValue() {
        return value;
    }

    public int getYear() {
        return year;
    }
}