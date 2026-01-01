package thread;

public class Ex03StringBuilderBuffer {
	public static void main(String[] args) {
		Task shareTask = new Task();
		
		Thread t1 = new Thread(shareTask, "thread-t1");
		Thread t2 = new Thread(shareTask, "thread-t2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("shareTask#lenght --> " + shareTask.length());
	}
	
	private static class Task implements Runnable{
		private StringBuffer storage;
		private static final int COUNT = 50000;
		
		public Task() {
			this.storage = new StringBuffer();
		}
		
		@Override
		public void run() {
			for(int i = 1; i<= COUNT;i++) {
				storage.append("x");
			}
		}
		
		public int length() {
			return storage.length();
		}
	}
}
