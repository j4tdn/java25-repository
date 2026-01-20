package thread;

public class Ex03StringBuilderBuffer {

	public static void main(String[] args) {
		
		Task sharedTask = new Task();
		
		Thread t1 = new Thread(sharedTask, "t1");
		Thread t2 = new Thread(sharedTask, "t2");
		
		t1.start();
		t2.start();
		
		System.out.println(sharedTask.length());
		
	}
	
	private static class Task implements Runnable{
		
		private StringBuffer storage;
		private static final int count = 50000;
		
		public Task() {
			this.storage = new StringBuffer();
		}
		
		@Override
			public void run() {
				for(int i = 1; i <= count; i++) {
					storage.append("x");
				}
				
			}
		
		public int length() {
			return storage.length();
		}
		
	}
}
