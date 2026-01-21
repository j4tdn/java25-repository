package thread;

import java.util.concurrent.TimeUnit;

public class Ex01Thread {
	
	private static long start = System.currentTimeMillis();
	public static void main(String[] args) {
		
		System.out.println("------ Băt đầu chương trình -------");
		
		
		// thread --> thread#start --> thread#run  --> truc tiep
		                                        // --> runnable#run
        
		Thread th1 = new Thread(new Task(), "Thread TH1"); 
		th1.start();
		
		Thread th2 = new Thread(() -> doTask02(), "Thread TH2"); 
		th2.start();
		
		System.out.println("================");
		doTask02();
		
		
		System.out.println("\n ---- Ket thc chuong trinh ----");
		System.out.println("Main finished after: " + (System.currentTimeMillis() - start) + "ms");
		
	}
	static class Task implements Runnable {
		@Override
		public void run() {
			doTask04();  // duoc thuc thi boi th1
			System.out.println("Th1 finish after: " + (System.currentTimeMillis() - start) + "(ms)");
			
		}
	}
	
	// giả lập xử lý công việc gì đó mất 2s
	private static void doTask02() {
		System.out.println("Doing Task 02 ... ");
		System.out.println("TH finished after: ");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish Task 02 ...");
	}
	
	// giả lập xử lý công vệc gì đó mất 4s
	private static void doTask04() {
		System.out.println("Doing Task 04");
		try {
			TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}
