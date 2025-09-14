package datastructure.object;
import bean.Item;
public class Ex03Assignments {
	
	public static void main(String[] args) {
				
		/* Để cập nhật giá trị cho biết là
		 * 
		 * KDL Nguyên Thủy
		 * --> Giá trị lưu ở STACK
		 * --> Thông qua toán tử gán '='--> Copy cập nhật giá trị tại vùng nhớ STACK
		 * 
		 * KDL Đối Tượng
		 * --> Giá trị thật sự của đối tượng lưu ở HEAP
		 * --> Giá trị của biến ở vùng nhớ STACK là địa chỉ của ô nhớ HEAP mà nó đang trỏ đến
		 * --> Thông qua toán tử gán '='--> Copy cập nhật giá trị(địa chỉ) tại vùng nhớ STACK
		 * --> Cập nhật giá trị thực tế ở vùng nhớ HEAP
		 * 
		 * Biến dù là KDL nguyên thủy hay đối tượng --> luôn nằm ở STACK
		 */
		int a1 = 10;
		int a2 = 20; 
		int a3 = 30;
		
		a2=a1;
		a3=a2;
		a1=60;
		a3=a1;
		System.out.println("a1 --> "+a1);
		System.out.println("a2 --> "+a2);
		System.out.println("a3 --> "+a3);
		
		System.out.println("\n\n");
		Item i1= new Item(1,'A', 11d);
		Item i2= new Item(2,'B', 22d);
		Item i3= new Item(3,'C', 33d);
		System.out.println("i1 --> "+i1);
		System.out.println("i2 --> "+i2);
		System.out.println("i3 --> "+i3);
		System.out.println("i1 code: " +System.identityHashCode(i1));
		System.out.println("i1 code: " +System.identityHashCode(i2));
		System.out.println("i1 code: " +System.identityHashCode(i3));
		// Update giá trị salePrice của i2 thành 44
		i2.salePrice = 44; // update giá trị tại vùng nhớ HEAP
		System.out.println("i2 -->"+i2);
		
		i1=i3; // update giá trị(địa chỉ) tại vùng nhớ STACK
		i1.salePrice =99;
		i2 = new Item();
		System.out.println("i1 --> "+i1);
		System.out.println("i2 --> "+i2);
		System.out.println("i3 --> "+i3);
		System.out.println("i1 code: " +System.identityHashCode(i1));
		System.out.println("i1 code: " +System.identityHashCode(i2));
		System.out.println("i1 code: " +System.identityHashCode(i3));
	}
	
}
