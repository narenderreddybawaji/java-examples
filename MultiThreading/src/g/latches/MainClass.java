package g.latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {
	public static void main(String[] args) throws ExecutionException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Service dataService = new Service("dataServiceClass");
		Service authenticationService = new Service("authenticationServiceClass");
		ServiceWorker serviceWorker1 = new ServiceWorker(countDownLatch, dataService);
		ServiceWorker serviceWorker2 = new ServiceWorker(countDownLatch, authenticationService);

		Future<Integer> future1 = executorService.submit(serviceWorker1);
		Future<Integer> future2 = executorService.submit(serviceWorker2);

		try {
			System.out.println("future1 complete "+ future1.get());
			System.out.println("future2 complete "+ future2.get());
			countDownLatch.await();
			System.out.println("Calling after all theards execution.");
			//server.start()
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}
