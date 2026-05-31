package view;

import service.WhAllocationService;

public class WhAllocationDemo {

	public static void main(String[] args) {
		WhAllocationService allocationSerive = new WhAllocationService();

		boolean isSuccess = allocationSerive.runAllocationProcess();

		if (isSuccess == true) {
			System.out.println("Next step");
		} else {
			System.out.println("Stop at this step");
		}

	}

}
