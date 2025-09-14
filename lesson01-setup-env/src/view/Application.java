package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Application {

	public static void main(String[] args) {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

}
