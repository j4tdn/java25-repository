package thread;

import java.util.concurrent.TimeUnit;

public class Ex02MultiThread {
	
	private static long start = System.currentTimeMillis();
	
	public static void main(String[] args) {
		
		Task t1 = new Task("Loading items from database", 4, TimeUnit.SECONDS);
		
		Task t2 = new Task("Process calculator", 2, TimeUnit.SECONDS);
		
		Task t3 = new Task("Export excel file", 5, TimeUnit.SECONDS);
		
		t1.run();
		t2.run();
		t3.run();
		
		System.out.println("Finishing Time(main) -> " +(System.currentTimeMillis() - start));
		
	}
	
	private static class Task implements Runnable{
		
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
			System.out.println("Task " + taskName + " is being executed by " + Thread.currentThread().getName());
			doTask();
			System.out.println("Finish task " + taskName + " after " + duration + "("+ unit.name() + ")");
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
