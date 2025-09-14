package exhomework;

import java.util.Scanner;

public class CheckInput {
    public static int getInput() {
        Scanner ip = new Scanner(System.in);
        String text;
        int wrongTimes = 0;

        while (true) {
            System.out.print("Nhập 1 số nguyên dương: ");
            text = ip.nextLine();

            if (check(text)) {
                int number = Integer.parseInt(text);
                if (number > 0) {
                    return number;
                }
            }

            wrongTimes++;
            if (wrongTimes == 5) {
                System.out.println("Số lần nhập sai vượt quá 5 lần. Thoát.");
                ip.close();
                return wrongTimes;
            }
            System.out.printf("Chưa phải là số nguyên dương hợp lệ (lần %d)%n%n", wrongTimes);
        }
    }

    private static boolean check(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}