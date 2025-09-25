package matchmaking;

public class AreCompatible {
	
	public AreCompatible() {
	}
	
	public static void areCompatible(Participants p1, Participants p2) {
		int count = 0;
		
		if(p1.isGender() != p2.isGender()) {
			count++;
		}
		
		int year = p1.getBirthDay().getYear() - p2.getBirthDay().getYear();
		if(Math.abs(year) <= 8) {
			count++;
		}
		
		String[] hobby1 = p1.getListHobby();
		String[] hobby2 = p2.getListHobby();
		int h = 0;
		for(String h1: hobby1) {
			for(String h2: hobby2) {
				if(h1.equalsIgnoreCase(h2)) h++;
			}
		}
		if(h >= 4) count++;
		
		if(count == 3) {
			System.out.println(p1);
			System.out.println(p2);
			System.out.print("So thich chung: ");
			for(String h1: hobby1) {
				for(String h2: hobby2) {
					if(h1 == h2) System.out.print(h1+ ", ");
				}
			}
		}
		else System.out.println("Rat tiec 2 ban khong hop nhau");
	}
}
