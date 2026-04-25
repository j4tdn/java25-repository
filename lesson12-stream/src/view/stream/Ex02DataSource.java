package view.stream;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02DataSource {

	public static void main(String[] args) {
		// Collection<E> --> Stream<E>
		// Stream.of || iterate || range[Closed] --> Stream<E> || Primitive[Int, Long,
		// Double] Stream

		// E[] --> Stream<E>
		// p_type[] --> Primitive[Int, Long Double] Stream

		Set<String> set = Set.of("a", "b", "c");
		Stream<String> sset = set.stream();

		Stream<String> stream = Stream.of("A1", "A2", "A3");
		
		int[] digits = {1,2,3};
		// Stream van luu tru duoc dữ liệu nhưng hiếm khi làm vậy
		// Hành động chỉ thao tác 1 lần duy nhất
		IntStream intStream = Arrays.stream(digits);
		generate("intstream",intStream.boxed());
	}

	private static <T> void generate(String prefix, Stream<T> stream) {
		System.out.println("prefix" +" {");
		stream.forEach(t -> {
			System.out.println("       - " + t);
		});
		System.out.println("}");
	}
}
