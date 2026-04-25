package view.stream.demo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import bean.Player;
import model.DataModel;

public class Ex03FlatMapCardDemo {
	
	// Bài tập:
	// Bài toán chơi bài, mỗi ván thì sẽ có 4 người chơi, mỗi người sẽ có 13 lá bài
	
	// >>>> Function: Trong 1 ván bài <<<
	// Khi 1 người về nhất, 3 người còn lại xem như là bên thua
	// Viết chương trình tìm ra trong danh sách người thua tại ván đấu, xem có người chơi nào cầm quân 2 chưa đi không
	
	// Yêu cầu tự tạo cấu trúc dữ liệu và xử lý chức năng trên
	
	public static void main(String[] args) {
		// Game function
		// Player: name, cards, gameStatus
		
		List<Player> players = DataModel.mockPlayerList();
		
		
		players.stream() // Stream<Player>
			.filter(Player::isLose) // Stream<Player>
			.map(Player::getCards) // Stream<List<String>>
			.flatMap(Collection::stream) // Stream<String>
			.filter(card -> card.startsWith("hai"))
			.forEach(System.out::println);
			
		players.stream() // Stream<Player>
		.filter(p -> p.isLose() && containStartsWith(p.getCards(), "hai")) // Stream<Player>
		.collect(Collectors.toMap(
			Player::getId, 
			p -> p.getCards().stream().filter(c -> c.startsWith("hai")).toList() // Stream<PlayerId, List<String>>
		)).forEach((k, v) -> System.out.println(k + " --> " + v ));
		
		
			
	}
	
	public static boolean containStartsWith(List<String> elements, String prefix) {
		return elements.stream().anyMatch(e -> e.startsWith(prefix));
	}
	
}
