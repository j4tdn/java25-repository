package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex06Throws {
	
	// compile (checked ) exception: là những exception bắt buộc mình phải xử lí tại thời điểm compile
	
	// runtime(unchecked) exception: là những exception không bắt buộc mình phải xử lí tại thời điểm compile
	
	// xảy ra: --> thì cả 2 loại trên đều có thể xảy ra lúc runtime , dù trong code có bắt buộc hay ko thì 100% mình phải xử lí exception đó 
	
	// Khi throw 1 complie exception , tại vị trí khai báo hàm phải throws để cho gọi hàm biết và bắt buộc phải xử lí exception đó
	
	// việc runtime là vô nghĩa 
	// vì bên trong hàm throw runtime exception nó ko bắt buộc phải throws , chỗ gọi hàm cx ko bất buộc xử lí 
	

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập tên file: ");
		String filename = ip.nextLine();
		
		try {
			creatFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		ip.close();
	}
	
	private static void creatFile(String filename) throws IOException {
		File file = new File(filename);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
}
