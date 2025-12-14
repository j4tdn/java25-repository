package view.datetime;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DateUtils.showCurrentTime("GMT+7");
        DateUtils.showLastDayOfCurrentMonth();
        DateUtils.showFirstAndLastDayOfWeek();
        DateUtils.showWeekOfYear();
        DateUtils.showDateAfter20Days();

        System.out.print("\nEnter your birthday (dd/MM/yyyy): ");
        String birthday = sc.nextLine();
        DateUtils.calculateDaysLived(birthday);

        sc.close();
    }
}
