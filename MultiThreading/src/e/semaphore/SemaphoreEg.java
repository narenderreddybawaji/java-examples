package e.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreEg {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);

		Runnable task = () -> {
			if (semaphore.tryAcquire()) {
				System.out.println("Task started by thread:" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task processed by thread:" + Thread.currentThread().getName());
				semaphore.release();
			} else {
				System.out.println("Skipping task as already in proces. Thread:" + Thread.currentThread().getName());
			}

		};

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(task);
		executorService.execute(task);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.execute(task);
		executorService.execute(task);
		
		executorService.shutdown();

	}
}
