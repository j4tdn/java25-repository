package ex02;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng xe: ");
        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

     
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin xe thứ " + (i + 1));
            vehicles[i] = VehicleUtils.inputVehicle(sc);
        }

        VehicleUtils.exportHeader();
        for (Vehicle v : vehicles) {
            VehicleUtils.export(v);
        }
        sc.close();
    }

}
