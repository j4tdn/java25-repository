package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import common.Color;
import functional.AppleCondition;
import static model.DataModel.*;
import static utils.PrintUtils.*;

public class Ex01Inventory {

	public static void main(String[] args) {
		List<Apple> apples = mockAppleList();
		
		generate("1. Kho hàng", apples);

		List<Apple> greenApples = filterApples(apples, (app) -> app.getColor() == Color.GREEN);
		generate("2. Danh sách táo màu xanh", greenApples);

		List<Apple> redApples = filterApples(apples, (app) -> app.getColor() == Color.RED);
		generate("3. Danh sách táo màu đỏ", redApples);
	}

	// tham số truyền vào là Functional Interface
	// truyền vào --> Implementation class: chỗ override lại method, dài, phức tạp, dùng cho nhiều vị trí (phải tạo thêm class)
	//            --> Anonymous class: override trực tiếp functional interface chỗ gọi
	//            --> Anonymous function(lambda): ngắn gọn nhất
	
	// Lambda: (parameters) -> {body}
	// - parameters
	//   + Nếu chỉ có 1 tham số --> ko cần ()
	//   + ko cần phải khai báo KDL cho parameter, vì override từ abstract method biết được từng tham số này kiểu gì rồi
	// - arrow
	// - body
	//   + Có thể là return KDL nào đó hoặc kiểu void
	//   + Nếu body chỉ có 1 dòng thì không cần {} ko cần từ khóa return
	
	
	public static List<Apple> filterApples(List<Apple> list, Predicate<Apple> pre) {
		List<Apple> results = new ArrayList<>();
		for (Apple item : list) {
			if (pre.test(item)) {
				results.add(item);
			}
		}
		return results;
	}
}
