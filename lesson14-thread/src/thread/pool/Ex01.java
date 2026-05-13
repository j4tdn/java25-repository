package thread.pool;

import static utils.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread Pool + pool size: number of threads + blocking queue: number of tasks
 */
public class Ex01 {

	private static long start = 0;
	private static int capacity = 20;
	private static Random rd = new Random();

	public static void main(String[] args) {
		System.out.println("Thread start");

		start = System.currentTimeMillis();
		// blocking queue
		List<Task> tasks = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; ++i) {
//			tasks.add(new Task());
			long time = 2 + rd.nextInt(6);
			tasks.add(new Task(time, TimeUnit.SECONDS));
		}

		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("processors: " + processors);
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (Task task : tasks) {
			service.execute(task);
		}

	}

	private static class Task implements Runnable {
		private long time;
		private TimeUnit unit;

		public Task(long time, TimeUnit unit) {
			this.time = time;
			this.unit = unit;
		}

		@Override
		public void run() {
			startThread(time);
			doTask(time, unit);
			endThread(start);
		}

	}
}
