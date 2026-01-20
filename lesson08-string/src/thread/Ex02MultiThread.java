package thread;

import java.util.concurrent.TimeUnit;

public class Ex02MultiThread {

    public static void main(String[] args) {
        // Tạo các task giả lập với thời gian chạy khác nhau
        Task t1 = new Task("Loading items from database", 4, TimeUnit.SECONDS);
        Task t2 = new Task("Process calculation", 2, TimeUnit.SECONDS);
        Task t3 = new Task("Export excel file", 5, TimeUnit.SECONDS);

        // Gán task cho các luồng (Thread)
        Thread th1 = new Thread(t1, "thread-th1");
        Thread th2 = new Thread(t2, "thread-th2");
        Thread th3 = new Thread(t3, "thread-th3");

        // Bắt đầu chạy các luồng
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
            long start = System.currentTimeMillis(); 
            
            System.out.println("Task '" + taskName + "' is being executed by " + Thread.currentThread().getName());
            
            doTask();
            
            System.out.println("--> Finished task " + taskName + " after " + (System.currentTimeMillis() - start) + "(ms)");
        }

        private void doTask() {
            try {
                while (duration != 0) {
                    System.out.println(">> " + taskName + "(" + duration + ")");
                    unit.sleep(1); // Ngủ 1 đơn vị thời gian (ở đây là 1 giây)
                    duration--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}