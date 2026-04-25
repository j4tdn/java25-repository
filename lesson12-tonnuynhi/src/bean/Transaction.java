package bean;

public class Transaction {
    private int id;
    private Trader trader;
    private int year; 
    private int value;

    public Transaction(int id, Trader trader, int year, int value) {
        this.id = id;
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    // Getters
    public Trader getTrader() { return trader; }
    public int getYear() { return year; }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return "Giao dich [Gia tri: " + value + ", Nam: " + year + ", " + trader + "]";
    }
}