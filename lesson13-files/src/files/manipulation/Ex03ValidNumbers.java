package files.manipulation;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import utils.FileUtils;

public class Ex03ValidNumbers {
	
	private static final String PATH_INPUT = "lesson13-files/storage/example/d3input.txt";
	private static final String PATH_OUTPUT = "lesson13-files/storage/example/d3output.txt";
	
	public static void main(String[] args) {
		
		/*
		 Yêu cầu:
		 - Từ dữ liệu đã cho ở file storage/example/d3input.txt. Biết rằng
		   + dòng đầu tiên: số chuỗi string tối đa xuất hiện bên dưới
		   + n dòng tiếp theo: mỗi dòng là 1 chuỗi String[chỉ chứa kí tự thường a-z và số]
		 
		 - Viết chương trình 
		 	+ Tìm số tự nhiên lớn nhất của mỗi xâu chuỗi, danh sách trả về in ra theo thứ tự tăng dần
		 	+ Kết quả tìm ra được lưu vào file storage/example.d3output.txt
		 */
		
		List<String> sortedNumberLines = FileUtils.read(PATH_INPUT).stream() // Stream<String>
			.skip(1)
			.map(Ex03ValidNumbers::max)
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
