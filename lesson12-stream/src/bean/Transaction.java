package bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

	private String id;
	private Trader trader;
	private LocalDate dateCreated;
	private BigDecimal value;

	public Transaction() {
	}

	public Transaction(String id, Trader trader, LocalDate dateCreated, BigDecimal value) {
		this.id = id;
		this.trader = trader;
		this.dateCreated = dateCreated;
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

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
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
		return "Transaction [id=" + id + ", trader=" + trader + ", dateCreated=" + dateCreated + ", value=" + value
				+ "]";
	}
}