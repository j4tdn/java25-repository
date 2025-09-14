package Exercise;
import java.util.*;

public class Ex10RandomNumber {
    public static void main(String[] args) {
    	
        //Tạo danh sách chứa các số từ 20 đến 30:
    	
        List<Integer> numbers = new ArrayList<>();
        for (int i = 20; i <= 30; i++) {
            numbers.add(i);
        }

        // Trộn ngẫu nhiên danh sách:
        
        Collections.shuffle(numbers);

        // In ra 5 số đầu tiên (sau khi trộn thì đã ngẫu nhiên và không trùng nhau)
        
        System.out.println("5 số ngẫu nhiên trong đoạn [20,30] là:");
        for (int i = 0; i < 5; i++) { // vòng lặp chạy 5 lần từ i = 0 > i = 4
            System.out.print(numbers.get(i) + " "); // lấy phần từ ở vị trí thứ i trong danh sách numbers ra và in.
        }
    }
}

