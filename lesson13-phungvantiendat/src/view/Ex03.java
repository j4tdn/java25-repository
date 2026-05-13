package view;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static utils.FileUtils.*;

public class Ex03 {
	private static final String PATH_INPUT = "data/input.txt";
	private static final String PATH_OUTPUT = "data/output.txt";
	
	public static void main(String[] args) {
		List<String> lines = read(PATH_INPUT)
				.stream()
				.map(Ex03::max)
				.filter(Objects::nonNull)
				.sorted()
				.map(String::valueOf)
				.toList();
		
		writeAndOpen(PATH_OUTPUT, lines);
	}
	
	private static Integer max(String line) {
		return Pattern.compile("[^\\d]+").splitAsStream(line)
				.filter(text -> !text.isEmpty())
				.map(Integer::parseInt)
				.reduce(Integer::max)
				.orElse(null);
	}

}
