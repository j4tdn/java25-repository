package matchmaking;

import java.time.LocalDate;

public class Ex04MatchMaking {
	public static void main(String[] args) {
		Participants p1 = new Participants("Dang Hoang Huy", true, "Da Nang", new String[] {
				"Da bong",
				"Xem phim",
				"Lam mong",
				"An uong",
				"Choi phi phai",
				"Cuoi"
		}, LocalDate.of(2005, 8, 21));
		
		Participants p2 = new Participants("Hoang Cuu Bao", true, "Ha Noi", new String[] {
				"Da bong",
				"Xem phim",
				"Lam mong",
				"Co bac",
				"Choi lien quan"
		}, LocalDate.of(20015, 8, 21));
		
		Participants p3 = new Participants("Nguyen Thi No", false, "Vu Dai", new String[] {
				"Da bong",
				"Xem phim",
				"Lam mong",
				"An uong",
				"Nau Chao"
		}, LocalDate.of(1990, 8, 21));
		
		Participants p4 = new Participants("Nguyen Chi Pheo", true, "Vu Dai", new String[] {
				"Da bong",
				"Xem phim",
				"Lam mong",
				"An uong",
				"An va"
		}, LocalDate.of(1995, 8, 21));
		
		AreCompatible.areCompatible(p1, p2);
		
		System.out.println("\n\n");
		
		AreCompatible.areCompatible(p3, p4);
	}
}
