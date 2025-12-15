package view;

import s17p.EvenPredicate;
import s17p.Predicate;
import s17p.Shape;
import s17p.Square;

public class S17 {
	
	// S17: Functional Interface(FI) là interface có duy nhất 1 hàm trừu tượng
	
	// Sử dụng anonymous function(lambda) để khởi tạo đối tượng cho functional interface giúp code ngắn gọn
	
	// Để tạo đối tượng cho interface(bình thường[có bao nhiêu hàm trừu tượng cũng dc]):
	// 1 --> Tạo class implement từ interface đó xong rồi new class đó: dùng implementation class
	// 2 --> new trực tiếp interface: dùng anonymous class
	
	// Với interface có 1 hàm trừu tượng duy nhất(@FI)
	// Sử dụng cách 1, 2 phía trên: implementation, anonymouse class để tạo đối tươnngj
	// Sử dung 3 --> anonymous function(lambda) để tạo đối tượng cho ngắn gọn
	
	public static void main(String[] args) {
		// Có 2 cách để khởi tạo đối tượng cho interface bình thường
		
		// 1. impl class
		Shape s1 = new Square();
		
		// 2. anonymous class
		Shape s2 = new Shape() {
			
			@Override
			public void draw() {
			}
			
			@Override
			public void clear() {
			}
		};
		
		
		// Có 3 cách để khởi tạo đối tượng cho functional interface
		
		// 1. impl class
		Predicate p1 = new EvenPredicate();
		
		// 2. anonymous class
		Predicate p2 = new Predicate() {
			
			@Override
			public boolean test(int val) {
				return val % 2 == 0;
			}
		};
		
		// 3. anonymous function(lambda)
		Predicate p3 = val -> val % 2 == 0; 
	}
	
}