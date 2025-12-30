package thread;

import java.util.concurrent.TimeUnit;

public class Ex01Thread {
	
	private static long start = System.currentTimeMillis();

	public static void main(String[] args) {
		System.out.println("--- Bat dau chuong trinh ---\n");
		System.out.println("Thread hien tai (main#method): " + Thread.currentThread());

//		Thread th1 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				doTask4();
//				System.out.println("TH1 finished after: " + (System.currentTimeMillis() - start) + "(ms)");
//			}
//		}, "Thread TH1");
		
		Thread th1 = new Thread(new Task(), "TH1 thread");

		th1.start();

		System.out.println("============");

		doTask2();

		System.out.println("--- Ket thuc chuong trinh ---");

		System.out.println("Main Thread finished after: " + (System.currentTimeMillis() - start) + "(ms)");
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			doTask4();
			System.out.println("TH1 finished after: " + (System.currentTimeMillis() - start) + "(ms)");
		}
		
	}

	private static void doTask2() {
		System.out.println("Doing Task 02 ...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 02 ...");
	}

	private static void doTask4() {
		System.out.println("Doing Task 04 ...");
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 04 ...");
	}
}
