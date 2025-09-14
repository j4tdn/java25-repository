package lesson2.assignments;

public class Ex10 {

	private static int[] p = new int[10000005];

	public static void main(String[] args) {
		for(int i = 0;i<5;++i) {
			int rand = (int)(Math.random() * (30 - 20)) + 10;
			if(p[rand] == 0) {
				System.out.println(rand);
				p[rand]++;
			}
		}
	}

}
