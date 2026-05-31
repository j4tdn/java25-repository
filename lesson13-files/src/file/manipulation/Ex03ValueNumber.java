package file.manipulation;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import utils.FileUtils;

public class Ex03ValueNumber {
	
	private static final String PATH_OUTPUT = "lesson13-files/storage/example/d3output.txt";
	// Sửa lỗi chính tả: PATH_INTPUT -> PATH_INPUT
	private static final String PATH_INPUT = "lesson13-files/storage/example/d3input.txt";
	
	public static void main(String[] args) {
		List<String> sortedNumberLines = FileUtils.read(PATH_INPUT).stream() // Stream<String>
	            .skip(1)
	            .map(Ex03ValueNumber::max)
	            .filter(Objects::nonNull)
	            .sorted()
	            .map(String::valueOf) // convert kết quả sang String để đưa vào output.txt
	            .toList();

	    FileUtils.writeAndOpen(PATH_OUTPUT, sortedNumberLines);
	}

	private static Integer max(String line) {
	    return Pattern.compile("[^\\d]+").splitAsStream(line) // Stream<String>
	            .filter(text -> !text.isEmpty())
	            .map(Integer::parseInt) // Stream<Integer>
	            .reduce(Integer::max)
	            .orElse(null); // Integer
	}
}