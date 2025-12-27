package thread;

import java.util.concurrent.TimeUnit;

public class Ex01Thread {
	
	private static long start = System.currentTimeMillis(); 
	
	public static void main(String[] args) {
		System.out.println("--- Bắt đầu chương trình ---\n");
		
		// thread --> thread#start --> thread#run --> trực tiếp
		//                                        --> runnable#run
		
		Thread th1 = new Thread(new Task(), "Thread TH1");
		th1.start();
		
		Thread th2 = new Thread(() -> doTask2(), "Thread TH2"); // ExecutorService(ThreadPool)
		th2.start();
		
		System.out.println("=============");
		
		doTask2();
		
		System.out.println("\n--- Kết thúc chương trình ---");
		System.out.println("Main finished after: " + (System.currentTimeMillis() - start) + "(ms)");
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			doTask4(); // được thực thi bởi th1
			System.out.println("TH1 finished after: " + (System.currentTimeMillis() - start) + "(ms)");
		}
		
	}
	
	// Giải lập xử lý công việc gì đó mất 2s
	private static void doTask2() {
		System.out.println("Doing Task 02 ...");
		System.out.println("Task 02 is executed by: " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 02 ...");
	}
	
	// Giải lập xử lý công việc gì đó mất 4s
	private static void doTask4() {
		System.out.println("Doing Task 04 ...");
		System.out.println("Task 04 is executed by: " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 04 ...");
	}
	
}
