package i.concurrent.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProducerConsumerQueue {
	public static void main(String[] args) throws InterruptedException {
		// Main method start

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

		class Consumer implements Callable<String> {
			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 10) {
					queue.take();
				}
				return "Consumed " + (count - 1);
			}

		}
		class Producer implements Callable<String> {
			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 10) {
					queue.put(Integer.toString(count));
				}
				return "Produced " + (count - 1);
			}
		}

		List<Callable<String>> producersAndConsumers = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			producersAndConsumers.add(new Producer());
		}
		for (int i = 0; i < 2; i++) {
			producersAndConsumers.add(new Consumer());
		}

		System.out.println("Producers & Consumers launched");

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);
		try {
			futures.forEach(future -> {
				try {
					System.out.println(future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		} finally {
			executorService.shutdown();
		}
		System.out.println("Executor service shut down");
		// Main method end
	}
}
