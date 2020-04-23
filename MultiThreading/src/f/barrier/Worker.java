package f.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Callable<List<Integer>> {

	private CyclicBarrier cyclicBarrier;
	private List<Integer> inputList;

	public Worker(CyclicBarrier cyclicBarrier, List<Integer> inputList) {
		this.cyclicBarrier = cyclicBarrier;
		this.inputList = inputList;
	}

	@Override
	public List<Integer> call() throws Exception {
		List<Integer> result = findPrimes(inputList);
		try {
			System.out.println(
					"Thread " + Thread.currentThread().getName() + " is waiting for other threads to process.");
			cyclicBarrier.await();
			System.out.println("Again execution:" + Thread.currentThread().getName());
			
			//In case cyclic barrier reaches at declaration point by called from await() by different threads.
			//Its value got reset and we can use it again.
			//E.g. writing again cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		return result;
	}

	private List<Integer> findPrimes(List<Integer> inputList) {
		List<Integer> primeNumberList = new ArrayList<>();
		boolean isPrime = false;
		for (int input : inputList) {
			isPrime = true;
			if (input > 2) {
				for (int i = 2; i <= input / 2; i++) {
					if (input % i == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if (isPrime) {
				primeNumberList.add(input);
			}
		}
		return primeNumberList;
	}

}
