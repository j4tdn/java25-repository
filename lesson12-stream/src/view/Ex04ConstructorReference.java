package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import bean.Apple;
import bean.Vector;
import common.Color;
import model.DataModel;


public class Ex04ConstructorReference {
	
	// Dạng: output return gọi hàm khởi tạo
	// Vector::new constructor reference --> ref đến constructor nhưng để biết chính xác constructor nào
	// thì phải dựa vào abstract method của functional interface bên trái

	public static void main(String[] args) {
		Supplier<Vector> s1 = () -> new Vector();
		Supplier<Vector> s2 = Vector::new;
		
		
		Function<Integer, Vector> f1 = (x) -> new Vector(x);
		Function<Integer, Vector> f2 = Vector::new;
		
		
		BiFunction<Integer, Integer, Vector> bf1 = (x,y) -> new Vector(x, y);
		BiFunction<Integer, Integer, Vector> bf2 = Vector::new;
		
		List<String> lines = DataModel.readAppleFromFile();
		
		List<Apple> target = readData(lines, Apple::new);
	}
	
	private static <R> List<R> readData(List<String> lines, Function<String, R> function) {
		List<R> target = new ArrayList<>();
		for(String line: lines) {
			target.add(function.apply(line));
		}
		return target;
	}

}
