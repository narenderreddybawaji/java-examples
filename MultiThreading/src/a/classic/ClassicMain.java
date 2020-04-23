package a.classic;

public class ClassicMain {

	public static void main(String[] args) {
		System.out.println("----------------");
		Runnable task = () -> System.out.println("I am thread " + Thread.currentThread().getName());
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("----------------");
	}

	/* Cons: 1. In multiple env, we can lead to multiples thread in case main
	 method called multiple time.
	 2. Thread dies once it process resource
	 Sol: We need to create thread pool but it is complex
	 */

}
