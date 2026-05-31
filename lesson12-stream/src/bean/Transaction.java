package bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

	private String id;
	private Trader trader;
	private LocalDate date;
	private BigDecimal value;
	
	public Transaction() {
	}

	public Transaction(String id, Trader trader, LocalDate date, BigDecimal value) {
		super();
		this.id = id;
		this.trader = trader;
		this.date = date;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Transaction that)) {
			return false;
		}
		return getId() == that.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", trader=" + trader + ", date=" + date + ", value=" + value + "]";
	}
	
}
