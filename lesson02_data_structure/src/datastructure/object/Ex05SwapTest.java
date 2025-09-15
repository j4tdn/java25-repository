package datastructure.object;
import bean.Item;
public class Ex05SwapTest {

	public static void main(String[] args) {
		
		CustomInt al = new CustomInt (5);
		CustomInt a2 = new CustomInt (7);
		System.out.println("=== before swap ===");
		System.out.printf("a1(%s) a2(%s)\n", al, a2); // 5 7
		swap (al, a2);
		System.out.println("=== after swap ===");
		System.out.printf("a1(%s) a2(%s)\n", al, a2);
		}
	
		private static void swap(CustomInt a, CustomInt b) { 
		int temp = a. value;
		a.value = b. value;
		b. value = temp;
	
	}
}
