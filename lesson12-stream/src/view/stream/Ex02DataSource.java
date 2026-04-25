package view.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static utils.NumberUtils.*;

public class Ex02DataSource {

public static void main(String[] args) {
	
	Set<String> set = Set.of("a", "b", "c");
	Stream<String> sset = set.stream();
	
	Stream<String> stream = Stream.of("A1", "A2", "A3");
	
	BigDecimal[] numbers = {bd("1"), bd("2"), bd("3")};
	Stream<BigDecimal> sbigdecimal = Arrays.stream(numbers);
	
	int[] digits = {1,2,3};
	IntStream intStream =  Arrays.stream(digits);
	generate("intStream", intStream.boxed()); //Primitive Stream --> boxed --> Stream<T>
	
}

	private static <T> void generate(String prefix, Stream<T> stream){
		System.out.println(prefix + "{ ");
		stream.forEach(t -> {
			System.out.println("     -" + t);
		});
		System.out.println("}");
	}
	
}
