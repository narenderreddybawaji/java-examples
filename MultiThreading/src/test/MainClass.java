package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
	public static void main(String[] args) {
		Runnable task1 = () -> {
			System.out.println("Hello");
		};
		
		ExecutorService executorService =  Executors.newFixedThreadPool(1);
		executorService.execute(task1);
		executorService.shutdown();
	}
}
