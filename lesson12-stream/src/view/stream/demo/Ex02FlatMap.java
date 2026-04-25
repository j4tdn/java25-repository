package view.stream.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex02FlatMap {
	public static void main(String[] args) {
		// s1 -> Stream<T> <-- mapping -- > Stream<R> -> s2
		List<String> words = List.of("hello", "java21", "programing");
		generate(
			"1. Chuyen đoi từ string -> length",
			words. stream().map(String:: length) . toList()
		);

		// s1 -> Stream<Collection<T>> <-- flatMap -- > Stream<T> -> s2
		// s1 -> Stream<T[]> <-- flatMap -- > Stream<T> -> s2
		
		List<Set<Integer>> list = List.of(
			    Set.of(1,11,21),
			    Set.of(2,3,4),
			    Set.of(10, 20)
			);

		List<Integer> flattenList = list.stream() // Stream<Set<E>>
		    .flatMap(Collection::stream) // Stream<E>
		    .toList();
		generate(
		    "2. Gom các phần tử từ list<set>",
		    flattenList
		);

		String[][] letters = {
		    {"A", "B"},
		    {"C", "D", "E"}
		};

		String[] flatenArray = Arrays.stream(letters) // Stream<E[]>
		    .flatMap(Arrays::stream) // Stream<E>
		    .toArray(String[]::new); // E[]
		generate(
		    "2. Gom các phần tử từ list<set>",
		    flatenArray
		);
		
		
		// >>>> Function: Trong 1 ván bài <<<
		// Khi 1 người về nhất, 3 người còn lại xem như là bên thua
		// Viết chương trình tìm ra trong danh sách người thua tại tại ván đấu, xem có người chơi nào cầm quân 2 chưa đi không

		// Bài tập:
		// Bài toán chơi bài, mỗi ván thì sẽ có 4 người chơi, mỗi người sẽ có 13 lá bài

		// Yêu cầu tự tạo cấu trúc dữ liệu và xử lý chức năng trên

	}
}
