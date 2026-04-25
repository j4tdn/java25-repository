package view.stream.demo;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SQLOutputImpl;

import org.w3c.dom.ls.LSOutput;

import bean.Player;
import common. GameStatus;
import model.DataModel;

public class Ex03FlatMapCardDemo {
	public static void main(String[] args) {
		System.out.println();
		
		List<Player> players = DataModel.mockPlayerList();
		
		players.stream()
			.filter(Player::isLose)
			.map(Player::getCards)
			.flatMap(Collection::stream)
			.filter(card -> card.startsWith("hai"))
			.forEach(System.out::println);
		
		players.stream() // Stream<Player>
		.filter(p -> p.isLose() && containStartsWith(p.getCards(), "hai")) // Stream<Player>
		.collect(Collectors.toMap(
		Player :: getId,
		p -> p.getCards().stream().filter(c -> c.startsWith("hai")).toList() // Stream<PlayerId, List<String>>
		)).forEach((k, v) -> System.out.println(k + " -- > " + v ));

		
	}
	public static boolean containStartsWith(List<String> elements, String prefix) {
		return elements.stream().anyMatch(e -> e.startsWith(prefix));
	}
	
}
