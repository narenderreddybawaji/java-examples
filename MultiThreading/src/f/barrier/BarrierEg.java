package f.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BarrierEg {

	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			inputList.add(i);
		}
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		Worker worker1 = new Worker(cyclicBarrier, inputList.subList(0, 24));
		Worker worker2 = new Worker(cyclicBarrier, inputList.subList(25, 49));
		Worker worker3 = new Worker(cyclicBarrier, inputList.subList(50, 74));
		Worker worker4 = new Worker(cyclicBarrier, inputList.subList(75, 99));
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		Future<List<Integer>> future1 = executorService.submit(worker1);
		Future<List<Integer>> future2 = executorService.submit(worker2);
		Future<List<Integer>> future3 = executorService.submit(worker3);
		Future<List<Integer>> future4 = executorService.submit(worker4);
		
		try {
			List<Integer> primeNumberList = new ArrayList<>(future1.get());
			primeNumberList.addAll(future2.get());
			primeNumberList.addAll(future3.get());
			primeNumberList.addAll(future4.get());
			System.out.println("----------------------------------------");
			primeNumberList.forEach(System.out::println);
			System.out.println("----------------------------------------");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
	

}
