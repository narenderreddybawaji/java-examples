package c.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> task = () -> {
			Thread.sleep(1000);
			return "I am in thread" + Thread.currentThread().getName();
		};

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(task);
			System.out.println("I get: " + future.get());
		}
		
		
		System.out.println("bye");
		executorService.shutdown();
	}
}
