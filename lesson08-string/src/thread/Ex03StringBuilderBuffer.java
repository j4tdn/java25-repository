package thread;

public class Ex03StringBuilderBuffer {
	public static void main(String[] args) {
		Task sharedTask = new Task();
		
		Thread th1 = new Thread(sharedTask, "thread-th1");
		Thread th2 = new Thread(sharedTask, "thread-th2");
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		
		System.out.println("sharedTask#length: " + sharedTask.lenght());
	}
	
	private static class Task implements Runnable {
		private StringBuffer storage;
		private static final int Count = 50000;
		
		
		
		public Task() {
			this.storage = new StringBuffer();
		}



		@Override
		public void run() {
			for (int i = 0; i < Count; i++) {
				storage.append("x");
			}
		}
		public int lenght() {
			return storage.length();
		}
	}

}
