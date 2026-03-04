package thread;

public class Ex03StringBuilderBuffer {
	
	public static void main(String[] args) {
		Task sharedTask = new Task();
		
		Thread t1 = new Thread(sharedTask, "thread-t1");
		Thread t2 = new Thread(sharedTask, "thread-t2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sharedTask#length --> " + sharedTask.length());
	}
	
	private static class Task implements Runnable {
		
		private StringBuilder storage;
		private static final int COUNT = 5000;
		
		public Task() {
			this.storage = new StringBuilder();
		}
		
		@Override
		public void run() {
			for (int i = 1; i <= COUNT; i++) {
				storage.append("x");
			}
		}
		
		public int length() {
			return storage.length();
		}
		
	}
	
}