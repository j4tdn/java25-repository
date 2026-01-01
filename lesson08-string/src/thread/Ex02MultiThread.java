package thread;

import java.util.concurrent.TimeUnit;

public class Ex02MultiThread {
	public static void main(String[] args) {
		Task t1 = new Task("loading items from database ",4,TimeUnit.SECONDS);
		Task t2 = new Task("Process caculation ",2,TimeUnit.SECONDS);
		Task t3 = new Task("Export excel ",5,TimeUnit.SECONDS);
		
		Thread th1 = new Thread(t1, "threaad-th1");
		Thread th2 = new Thread(t2, "threaad-th2");
		Thread th3 = new Thread(t3, "threaad-th3");
		
		th1.start();
		th2.start();
		th3.start();
	}
	private static class Task implements Runnable {
		private String taskName;
		private long duration;
		private TimeUnit unit;
		
		
		public Task(String taskName, long duration, TimeUnit unit) {
			this.taskName = taskName;
			this.duration = duration;
			this.unit = unit;
		}


		@Override
		public void run() {
			System.out.println("Task " + taskName + "is beint executed by " + Thread.currentThread().getName());
			doTask();
			System.out.println("Finished task " + taskName + "after" + duration + "(" + unit.name());
		}
		
		private void doTask() {
			try {
				
				unit.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
