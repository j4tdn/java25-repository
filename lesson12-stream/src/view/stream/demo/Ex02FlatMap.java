package view.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static utils.PrintUtils.*;

public class Ex02FlatMap {
	public static void main(String[] args) {
		// mapping: s1 -> Stream<T> - Stream<R> -> s2
		// flatMap: s1 -> Stream<Collection<T>> - Stream<T> -> s2
		
		List<String> words = List.of("hello","java21","programming");
		
		generate("1. Chuyển đổi từ string -> length", words.stream().map(String::length).toList());
		
		List<Set<Integer>> list = List.of(
				Set.of(1, 11, 21),
				Set.of(2, 3, 4),
				Set.of(10, 20)
		);
		
		List<Integer> flattenList =list.stream()
			.flatMap(set -> set.stream())
			.toList();
		
		generate(
				"2. Gom các phần tử từ list<Set>",
				flattenList
		);
		
		String[][] letters = {
				{"A", "B"},
				{"C", "D", "E"}
		};
		
		String[] flattenArray = Arrays.stream(letters)
			.flatMap(Arrays::stream)
			.toArray(String[]::new);
		
		generate(
				"3. Gom các phần tử mảng 2 chiều",
				flattenArray
		);
		
		// Bài tập:
		// Bài toán chơi bài, mỗi ván sẽ có 4 người chơi, mỗi người sẽ có 13 lá bài
		
		// >>>> Function: Trong 1 ván bài <<<<
		// Khi 1 người về nhất, 3 người còn lại xem như là bên thua
		// Viết chương trình tìm ra trong danh sách người thua tại ván đấu, xem có người chơi nào cầm quân 2 chưa đi không
		
		// Yêu cầu tự tạo CTDL và xử lý chức năng trên
	}
}
