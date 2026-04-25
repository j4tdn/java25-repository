package view.set;

import java.util.HashSet;
import java.util.Set;
import static utils.PrintUtils.*;
public class Ex01SetDemo {
	
	public static void main(String[] args) {
		Set<String> elements = new HashSet<>();
		elements.add("A2");
		elements.add("C1");
		elements.add("E7");
		elements.add("B8");
		elements.add("D9");
		elements.add("E7");
		generate("1. Element", elements);		
			}
	}
