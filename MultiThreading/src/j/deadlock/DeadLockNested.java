package j.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockNested {
	String name;

	public DeadLockNested(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		DeadLockNested instance1 = new DeadLockNested("instance1");
		DeadLockNested instance2 = new DeadLockNested("instance2");

		Runnable task1 = () -> {
			while (true) {
				synchronized (instance1) {
					System.out.println("inside instance1");
					synchronized (instance2) {
						System.out.println("inside instance1-instance2");
					}
				}
			}
		};

		Runnable task2 = () -> {
			while (true) {
				synchronized (instance2) {
					System.out.println("inside instance2");
					synchronized (instance1) {
						System.out.println("inside instance2-instance1");
					}
				}
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(task1);
		executorService.execute(task2);

		executorService.shutdown();
	}

	// We can resolve pb by making synchronized sequence instance1->instance2
	// instead instance2->instance1 of task2.
}
