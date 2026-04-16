package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.xml.transform.ErrorListener;

import bean.Apple;
import bean.Vector;
import common.Color;
import model.DataModel;
import utils.PrintUtils;

public class Ex04ConstructorReference {
	
	public static void main(String[] args) {
		/*
		 Để tạo đối tượng cho
		 - interface[1 hoặc nhiều hàm trừu tượng]: 
		   . tạo 1 lớp thực thi, override 1 hoặc nhiều hàm trừu tượng --> new lớp thực thi
		   . new interface ra, override ... --> sử dụng anonymous class
		   
		 - functional interface
		  . giống như trên: implementation class
		  .               : anonymouse class
		  . sử dụng anonymous function[lambda] để override lại hàm trừu tượng
		    --> method reference
		        - có 2 dạng: non static method reference [1 số dạng đặc biệt ghi nhớ]
		                         static method reference [có công thức]
		                         --> tạo ra 1 hàm static ở bất kỳ class nào mình muốn
		                         --> thay anonymous function = function cụ thể
		                             khi thấy lambda dài và có thể reuse 1 số chỗ --> method reference
		    --> constructor reference
		        - khi lambda (parameters ...) -> {body} có body return gọi đến 1 hàm khởi tạo thay thế nó
		          bằng constructor reference với dạng ClassName::new
		 */
		
		// Dạng: output return gọi hàm khởi tạo
		// Vector::new constructor reference --> ref đến constructor nhưng để biết chính xác constructor nào
		// thì phải dựa vào abstract method của Functional Interface bên trái
		
		Supplier<Vector> s1 = () -> new Vector();
		Supplier<Vector> s2 = Vector::new;
		
		Function<Integer, Vector> f1 = x -> new Vector(x);
		Function<Integer, Vector> f2 = Vector::new;
		Function<String, Vector> f3 = Vector::new;
		
		BiFunction<Integer, Integer, Vector> bf1 = (x, y) -> new Vector(x, y);
		BiFunction<Integer, Integer, Vector> bf2 = Vector::new;
		
		
		List<String> lines = DataModel.readApplesFromFile();
		
		List<Apple> target = readData(lines, Apple::new);
				
		PrintUtils.generate("Dữ liệu sau khi đọc từ fle", target);
	}
	
	private static <R> List<R> readData(List<String> lines, Function<String, R> function) {
		List<R> target = new ArrayList<>();
		for(String line: lines) {
			target.add(function.apply(line));
		}
		return target;
	}
	
	
}
