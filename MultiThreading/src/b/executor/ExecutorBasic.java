package b.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorBasic {
	public static void main(String[] args) {
		System.out.println("-------------------------------");
		Runnable task = () -> System.out.println("Calling runnble from executor. " + Thread.currentThread().getName());

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(task);
		executorService.execute(task);

		executorService.shutdown();
		System.out.println("-------------------------------");
	}
}
