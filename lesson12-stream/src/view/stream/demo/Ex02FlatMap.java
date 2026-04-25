package view.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static utils.PrintUtils.*;
public class Ex02FlatMap {
	
	
	public static void main(String[] args) {
		
		List<String> words = List.of("hello", "java21", "programing");
		
		generate("1. chuyển đổi tiwf string -> lenght",
				words.stream().map(String :: length).toList()
		);
		
		
		
		List<Set<Integer>> list = List.of(
				Set.of(1,11,21),
				Set.of(2,3,4),
				Set.of(10,20)
				);
		
		List<Integer> flattenList = list.stream()
			.flatMap(set -> set.stream())
			.toList();
		generate(
				"2. Gom các phần tưr từ list<set", 
				flattenList
				);
	String[][] letters = {
			{"A","B"},
			{"C", "D", "E"}
	};
	
	String[] flatenArray = Arrays.stream(letters)
	.flatMap(Arrays::stream)
	.toArray(String[]::new);
	
	generate("2. Gom các phần tưr từ list<set>",
			flatenArray
			);
	}
	// Bài tập:
	// Bài toán chơi bài, mỗi ván thì sẽ có 4 người chơi, mỗi người sẽ có 13 lá bài

	// >>> Function trong bài <<<

	// Khi 1 người về nhất, 3 người còn lại xem như là bến thua
	// Viết chương trình tìm ra trong danh sách người thua tại ván đầu, xem có người chơi nào cảm quan 2 chưa đi không

	// Yêu cầu tạo cấu trúc dữ liệu và xử lý chức năng trên

}
