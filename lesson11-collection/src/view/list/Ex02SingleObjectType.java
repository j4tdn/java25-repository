package view.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02SingleObjectType {
	public static void main(String[] args) {
		//intital, add, set, remove, removeif, get, iterate, forEach, forIndex...
		
		//List -->size
		//Array -->length
		//Sức chứa hiện tại tối đa của Array trong ArrayList trước khi tạo Array mới -> capacity
		
		
		List<String> elements = new ArrayList<>(); // java.util.ArrayList --> Dynamic size

        elements.add("a1"); elements.add("a6");
        elements.add("a2"); elements.add("a5");
        elements.add("a3"); elements.add("a4");

        System.out.println("size: " + elements.size());

        // Gọi các phương thức duyệt
        
        
        elements.set(1, "A3");
        elements.set(5, "A6");
        
        elements.remove(0); //by index
        elements.remove("A6"); //by object
        
        // A3 a2 a5 a3 A7 A8
        //Xóa các ptu có kí tự bắt đầu là 'A'
        //kết quả: a2 a5 a3
        elements.removeIf(e -> e.startsWith("A"));

        forEachList(elements);
        forIndexList(elements);
        iterateList(elements);
    }

    private static void forEachList(List<String> elements) {
        System.out.println("\n\nForEach ---> List");
        for (String element : elements) {
            System.out.println(element);
        }
    }

    private static void forIndexList(List<String> elements) {
        System.out.println("\n\nForIndex ---> List");
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
    }
    
    private static void iterateList(List<String> elements) {
    	System.out.println("iterate ---> List");
    	Iterator<String> iterator = elements.iterator();
    	while(iterator.hasNext()) {
    		String element = iterator.next();
    		System.out.println(element + "");
    	}
    }
}

