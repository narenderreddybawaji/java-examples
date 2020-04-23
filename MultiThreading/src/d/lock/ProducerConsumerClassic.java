package d.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerClassic {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		Runnable producerTask = () -> {

			while (true) {
				synchronized (list) {
					if (list.size() >= 5) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					int val = new Random().nextInt(10);
					list.add(val);
					System.out.println("Adding: producer val= " + val + "|| Size=" + list.size());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (list.size() < 5) {
						list.notifyAll();
					}
				}
			}

		};

		Runnable consumerTask = () -> {
			while (true) {
				synchronized (list) {
					if (list.size() == 0) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						list.notifyAll();
					}
					System.out
							.println("Removing: consumer val= " + list.get(list.size() - 1) + "|| Size=" + list.size());
					list.remove(list.size() - 1);

					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (list.size() > 0) {
						list.notifyAll();
					}
				}
			}

		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(producerTask);
		executorService.execute(consumerTask);

	}

}
