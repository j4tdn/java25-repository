package files.manipulation;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import utils.FileUtils;

public class Ex03ValidNumbers {
	
	private static final String PATH_INPUT = "data/storage/example/d3input.txt";
	private static final String PATH_OUTPUT = "data/storage/example/d3output.txt";

	public static void main(String[] args) {
		List<String> sortedNumberLines = FileUtils.read(PATH_INPUT).stream()
			.skip(1)
			.map(Ex03ValidNumbers::max)
			.filter(Objects::nonNull)
			.sorted()
			.map(String::valueOf)
			.toList();
		
		FileUtils.writeAndOpen(PATH_OUTPUT, sortedNumberLines);
	}
	
	private static Integer max(String line) {
		return Pattern.compile("[^\\d]+").splitAsStream(line)
						.filter(text -> !text.isEmpty())
						.map(Integer::parseInt)
						.reduce(Integer::max)
						.orElse(null);
	}

}
