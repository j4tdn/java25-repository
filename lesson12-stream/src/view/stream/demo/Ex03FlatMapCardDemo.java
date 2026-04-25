package view.stream.demo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import bean.Player;
import common.GameStatus;
import model.DataModel;

public class Ex03FlatMapCardDemo {
	
	public static void main(String[] args) {
		
     List<Player> player = DataModel.mockPlayerList();
     
     player.stream()
     	.filter(Player::isLose)
     	.map(Player::getCards)
     	.flatMap(Collection::stream)
     	.filter(card -> card.startsWith("hai"))
     	.forEach(System.out::println);
     
     player.stream()
     	.filter(p -> p.isLose() && containStartWith(p.getCards(),"hai"))
     	.collect(Collectors.toMap(
     			Player::getId,
     			p -> p.getCards().stream().filter(card -> card.startsWith("hai")).collect(Collectors.toList()) // sửa ở đây
     			)).forEach((k,v) -> System.out.println(k + " --> " + v ));
	}
	
	public static boolean containStartWith(List<String> elements, String prefix) {
		return elements.stream().anyMatch(e -> e.startsWith(prefix));
	}
}