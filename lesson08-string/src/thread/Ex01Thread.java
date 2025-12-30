package thread;

import java.util.concurrent.TimeUnit;

public class Ex01Thread {
	public static long start = System.currentTimeMillis();
	
	public static void main(String[] args) {
		
		System.out.println("-------Bắt đầu chương trình -------\n");
		
		//cách1 này dùng khi nào trong task đó nhiều code
		Thread th1 = new Thread(new Task(), "Thread TH1");
		th1.start();
		
		//cách2 này dùng khi nào ít code
		Thread th2 = new Thread(() -> doTask2(), "thread Th2");
		th2.start();
		
		System.out.println("===========");
		
		doTask2();
		
		System.out.println("\n----kết thúc chương trình-----");
		System.out.println("Main finished after: " + (System.currentTimeMillis()- start) + "(ms)");
	}
	
	//con của cách1
	static class Task implements Runnable{

		@Override
		public void run() {
			doTask4();
			System.out.println("TH1 finished after: " + (System.currentTimeMillis()- start) + "(ms)");
			
		}
		
	}

	
	// Giải lập xử lý công việc gì đó mất 2s
	private static void doTask2() {
		System.out.println("Doing Task 02...");
		System.out.println("Task 2 is execute by:" + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 02...");
	}

	
	// Giải lập xử lý công việc gì đó mất 4s
	private static void doTask4() {
		System.out.println("Doing Task 04 ...");
		System.out.println("Task 4 is execute by: " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(4);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 04 ...");
	}

}
