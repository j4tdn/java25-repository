package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex01 {

	public static void main(String[] args) {
		/**
		 * Thread t1 = new Thread(runnable); t1.start() >>> t1.run()[native method] >>
		 * t1.run() {runnable.run()}
		 */

		System.out.println("main start");

		Thread t1 = new Thread(new Task(), "thread1");

		// Khong nen code kieu nay
//		Thread t2 = new Thread() {
//			@Override
//			public void run() {
//				doTask(2, TimeUnit.SECONDS);
//				printCurrentThreadName();
//				System.out.println("running a task ...");
//			}
//		};

		t1.start();
		join(t1);

		Thread t2 = new Thread(new Task(), "thread2");
		t2.start();
		join(t2);

		printCurrentThreadName();

		System.out.println("main end");
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
//				doTask(2, TimeUnit.SECONDS);
			printCurrentThreadName();
			System.out.println("running a task ...");
		}
	}
	
	// block current thread untils finish
	private static void join(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
