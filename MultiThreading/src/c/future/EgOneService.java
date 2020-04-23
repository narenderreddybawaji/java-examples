package c.future;

public class EgOneService {

	public void m1() {
		System.out.println("m1 start , thread name=" + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1 end , thread name=" + Thread.currentThread().getName());
	}

	public void m2() {
		System.out.println("m2 start , thread name=" + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2 end, thread name=" + Thread.currentThread().getName());
	}
	
	public int m3() {
		System.out.println("m3 start , thread name=" + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m3 end, thread name=" + Thread.currentThread().getName());
		return 123;
	}

}
