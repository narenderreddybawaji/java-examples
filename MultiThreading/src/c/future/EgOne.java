package c.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EgOne {
	// Call m1() two times and m2() one time simultaneously

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Runnable runnable1 = () -> {
			new EgOneService().m1();
		};

		Runnable runnable3 = () -> {
			new EgOneService().m2();
		};

		Callable<Integer> callable = () -> {
			return new EgOneService().m3();
		};

		executorService.execute(runnable1);
		executorService.execute(runnable1);
		executorService.execute(runnable3);
		Future<Integer> future = executorService.submit(callable);
		try {
			System.out.println("Result is: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executorService.shutdown();

		// Callable<List<String>> task = () -> {_ _ _ so on
		// List<Callable<List<String>>> callList = new ArrayList<>();
		// callList.add(task);
		// callList.add(task);
		// List<Future<List<String>>> futureList =
		// executorService.invokeAll(callList);
		// System.out.println(futureList.get(0).get());
	}
}
