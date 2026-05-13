package thread.pool;

import static utils.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

/**
 * Thread Pool + pool size: number of threads + blocking queue: number of tasks
 */
public class Ex02 {

	private static long start = 0;
	private static int capacity = 20;
	private static Random rd = new Random();

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Thread start");

		start = System.currentTimeMillis();
		// blocking queue
//		List<Task> tasks = new ArrayList<>(capacity);
		List<FutureTask<Integer>> futureTask = new ArrayList<>();
		for (int i = 0; i < capacity; ++i) {
//			tasks.add(new Task());
			long time = 2 + rd.nextInt(6);
//			tasks.add(new Task());
			futureTask.add(new FutureTask<Integer>(new Task()));
		}

		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//		FutureTask
		for (FutureTask<Integer> task : futureTask) {
//			Future<Integer> future = service.submit(task);
//			FutureTask<Integer> futureTask = new FutureTask<>(task);
			service.submit(task);
			System.out.println("random: " + task.get());
		}

		service.shutdown();
		System.out.println("thread end");
	}

	private static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int rand = rd.nextInt(11) + 10;
			ThreadUtils.startThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return rand;
		}

	}
}
