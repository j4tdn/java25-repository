package view.stream.demo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import bean.Player;
import model.DataModel;

public class Ex03FlatMapCardDemo {

	// Bai tap
			// Bai toan choi bai, moi van se co 4 nguoi choi, moi nguoi se co 13 la
			// Trong 1 van bai 
			// Khi 1/4 nguoi ve nhat, 3 nguoi con lai xem nhu ben thua
			// Viet chuong trinh tim ra trong danh sach nguoi thua tai moi van, xem co nguoi choi nao cam 2 chua di k
	
	public static void main(String[] args) {
		
		// Game function
		
		// GamePlayer: GameId, RoomId, Players
		// Player: name, card, gameStatus
		
		List<Player> players = DataModel.mockPlayer();
		
		players.stream() // Stream<Player>
			.filter(Player::isLose) // Stream<Player>
			.map(Player::getCards) // Stream<List<String>>
			.flatMap(Collection::stream) // Stream<String>
			.filter(card -> card.startsWith("hai"))
			.forEach(System.out::println);
		
		players.stream() // Stream<Player>
	    .filter(p -> p.isLose() && containStartsWith(p.getCards(), "hai")) 
	    .collect(Collectors.toMap(
	        Player::getId, // Key: ID của người chơi
	        p -> p.getCards().stream()
	              .filter(c -> c.startsWith("hai"))
	              .toList() // Value: Danh sách các lá bài lọc được
	    )).forEach((k, v) -> System.out.println(k + " --> " + v));
	}
	
	private static boolean containStartsWith(List<String> es, String prefix) {
		return es.stream().anyMatch(e -> e.startsWith(prefix));
	}
	
}
