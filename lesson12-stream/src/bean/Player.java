package bean;

import java.util.List;
import java.util.Objects;

import common.GameStatus;

public class Player {

	private String id;
	private List<String> cards;
	private GameStatus status;
	
	public Player() {
	}

	public Player(String id, List<String> cards, GameStatus status) {
		this.id = id;
		this.cards = cards;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getCards() {
		return cards;
	}

	public void setCards(List<String> cards) {
		this.cards = cards;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}
	public boolean isLose() {
		return getStatus() == GameStatus.LOSE;
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) {
	        return true;
	    }

	    if (!(o instanceof Player that)) {
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
		return "Player [id=" + id + ", cards=" + cards + ", status=" + status + "]";
	}
	
}
