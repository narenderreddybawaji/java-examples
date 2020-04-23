package g.latches;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

// We can assume it AuthencationServiveWorker for e.g.
public class ServiceWorker implements Callable<Integer> {

	private CountDownLatch countDownLatch;
	private Service service;

	public ServiceWorker(CountDownLatch countDownLatch, Service service) {
		super();
		this.countDownLatch = countDownLatch;
		this.service = service;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("call() method from thread: " + Thread.currentThread().getName() + ", name of service= "
				+ service.getServiceName());
		if("dataServiceClass".equalsIgnoreCase(service.getServiceName())){
			Thread.sleep(1000);
		}
		service.init();
		countDownLatch.countDown();
		return 0;
	}

}
