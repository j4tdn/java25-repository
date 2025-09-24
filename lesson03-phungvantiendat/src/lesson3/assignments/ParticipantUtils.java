package lesson3.assignments;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bean.Participant;

public class ParticipantUtils {
	public static boolean isMatch(Participant z1, Participant z2) {
		if (z1.getGender().equalsIgnoreCase(z2.getGender())) {
			return false;
		}

		if (Math.abs(calcAge(z1.getDateOfBirth()) - calcAge(z2.getDateOfBirth())) > 8) {
			return false;
		}

		if (!isSameHobby(z1, z2)) {
			return false;
		}

		return true;
	}

	private static int calcAge(String dateOfBirth) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate dob = LocalDate.parse(dateOfBirth, dtf);

		LocalDate currentDate = LocalDate.now();

		Period period = Period.between(dob, currentDate);

		return period.getYears();
	}

	public static void printHobbies(Participant z1, Participant z2) {
		System.out.println("===== Thong tin cua hai ung vien =======");
		System.out.println("Nguoi thu nhat: "+ z1);
		System.out.println("Nguoi thu hai: "+ z2);
		System.out.println("========================================");
		System.out.println("So thich chung cua hai nguoi");
		List<String> hobbiesOfZ1 = z1.getHobbies();
		List<String> hobbiesOfZ2 = z2.getHobbies();
		for (String hobby : hobbiesOfZ1) {
			if (hobbiesOfZ2.contains(hobby)) {
				System.out.println(hobby + " ");
			}
		}
	}

	private static boolean isSameHobby(Participant z1, Participant z2) {
		int cnt = 0;
		List<String> hobbiesOfZ1 = z1.getHobbies();
		List<String> hobbiesOfZ2 = z2.getHobbies();
		for (String hobby : hobbiesOfZ1) {
			if (hobbiesOfZ2.contains(hobby)) {
				++cnt;
			}
		}
		return cnt >= 4;
	}
}
