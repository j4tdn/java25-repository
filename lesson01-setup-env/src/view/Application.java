package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("Welcome to eclipse 2025-R9");
		System.out.println("Today: " + DateTimeFormatter.ofPattern("dd/MM/yy").format(LocalDate.now()));
	}
}
