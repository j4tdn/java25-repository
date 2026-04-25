package view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import common.Color;
import model.*;
import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex01Inventory {

	public static void main(String[] args) {
		
		List<Apple> inventory = DataModel.mockAppleList();
		
		List<Apple> greenApples = filterApples(inventory, apple -> Color.GREEN.equals(apple.getColor()));
        
		List<Apple> redApples = filterApples(inventory, apple -> Color.RED.equals(apple.getColor()));
		
		List<Apple> heavyApples = filterApples(inventory, apple -> apple.getWeight().compareTo(bd("200")) > 0);
		
		generate("1. Kho hang", inventory);
		
		generate("2. DS tao mau xanh", greenApples);
		
		generate("3. DS tao mau do", redApples);
		
		generate("4. DS tao can nang hon 200gr", heavyApples);
	}
	
	// Tham số là functional interface
	// Truyền vào --> implementation class: chỗ override method dài, phức tạp, dùng cho nhiều vị trí [phải tạo thêm class]
	//	          --> anonymous class      : override trực tiếp functional interface chỗ gọi
	//	          --> anonymous function(lambda): ngắn gọn nhất

	// Lambda: (parameters) -> {body}
	// - parameters
	//   + nếu chỉ có 1 tham số --> ko cần ()
	//   + ko cần phải khai báo KDL cho parameter, vì override từ abstract method biết dc từng tham số này kiểu gì rồi
	// - arrow
	//   + bắt buộc
	// - body
	//   + có thể return KDL nào đó hoặc void
	//   + nếu chỉ có 1 dòng thì ko cần {} ko cần từ khóa return
	
	private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
		List<Apple> rs = new ArrayList<>();
        for (Apple apple: inventory) {
            if (predicate.test(apple)) {
                rs.add(apple);
            }
        }
        return rs;
	}
}
