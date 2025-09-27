package homework;

import java.util.Scanner;

import bean.Vehicle;

public class Ex02SoGiaoThong {

	public static void main(String[] args) {
		
		Vehicle[] listVehicles = null;
        Scanner ip = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======= CHƯƠNG TRÌNH TÍNH THUẾ =======");
            System.out.println("1. Nhập thông tin tạo N xe.");
            System.out.println("2. Xuất bảng kê khai tiền thuế.");
            System.out.println("3. Thoát chương trình.");
            System.out.println("=======================================");
            System.out.print("Mời bạn chọn chức năng: ");
            choice = ip.nextInt();
            ip.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tổng số lượng xe bạn muốn khai báo (N): ");
                    int n = ip.nextInt();
                    ip.nextLine();

                    listVehicles = new Vehicle[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin xe thứ " + (i + 1) + " ---");
                        System.out.print("Tên chủ xe: ");
                        String owner = ip.nextLine();
                        System.out.print("Loại xe: ");
                        String model = ip.nextLine();
                        System.out.print("Dung tích xylanh (cc): ");
                        int capacity = ip.nextInt();
                        System.out.print("Trị giá xe (VND): ");
                        double value = ip.nextDouble();
                        ip.nextLine();

                        listVehicles[i] = new Vehicle(owner, model, capacity, value);
                    }
                    System.out.println("==> Đã nhập xong thông tin cho " + n + " xe.");
                    break;
                case 2:
                    if (listVehicles == null) {
                        System.out.println("!!! Danh sách xe đang rỗng. Vui lòng chọn chức năng 1 để nhập dữ liệu.");
                        continue;
                    }

                    System.out.println("==========================================================");
                    System.out.println("Tên\t Loại xe\t Dung tích\t Trị giá\t Thuế phải nộp");
                    System.out.println("--------------------------------------------------------------------------------------------------");

                    for (Vehicle xe : listVehicles) {
                        System.out.printf("%s\t %s\t %s\t %s\t %s \n",
                                xe.getOwner(),
                                xe.getModel(),
                                xe.getCapacity(),
                                xe.getValue(),
                                xe.calcTax());
                    }
                    System.out.println("==========================================================");
                    break;
                case 3:
                    System.out.println("Cảm ơn đã sử dụng chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("!!! Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 3);

        ip.close();
		
	}
	
}
