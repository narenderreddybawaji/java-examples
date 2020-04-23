package j.deadlock;

public class DeadLockEg1 {
	
	private final String name;
	 
	 public DeadLockEg1(String name){
	  this.name = name;
	 }
	 public String getName() {
	  return this.name;
	 }

	public synchronized void method1(DeadLockEg1 deadLockEg1) {
		System.out.println(this.getName() + " has asked to call me " + deadLockEg1.getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deadLockEg1.method2();
	}

	public synchronized void method2() {
		System.out.println(this.getName() + " has is called.");
	}
	
	public static void main(String[] args) {
		DeadLockEg1 deadLockEg1Instance1 = new DeadLockEg1("DeadLockEg1Instance1");
		DeadLockEg1 deadLockEg1Instance2 = new DeadLockEg1("DeadLockEg1Instance2");
		
		Runnable task1= () -> {
			deadLockEg1Instance1.method1(deadLockEg1Instance2);
		};
		Runnable task2= () -> {
			deadLockEg1Instance2.method1(deadLockEg1Instance1);
		};
		
		new Thread(task1).start();
		new Thread(task2).start();
	}
}
