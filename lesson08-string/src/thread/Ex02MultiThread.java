package thread;

import java.util.concurrent.TimeUnit;

public class Ex02MultiThread {
    public static long start = System.currentTimeMillis();

    public static void main(String[] args) {
        Task t1 = new Task("Loading items from database", 4, TimeUnit.SECONDS);
        Task t2 = new Task("Process calculation", 2, TimeUnit.SECONDS);
        Task t3 = new Task("Export excel file", 5, TimeUnit.SECONDS);

        //Phân luồng
        Thread th1 = new Thread(t1, "Thread-1");
        Thread th2 = new Thread(t2, "Thread-2");
        Thread th3 = new Thread(t3, "Thread-3");

        //Đa luồng
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
            System.out.println("Task " + taskName + " is being executed by " + Thread.currentThread().getName());
            doTask();
            System.out.println("Finished Task " + taskName + " after " + (System.currentTimeMillis() - start) + " (ms)");
        }

        private void doTask() {
            try {
                while (duration != 0) {
                    System.out.println(">> " + taskName + " (" + duration + ")");
                    unit.sleep(1);
                    duration--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}