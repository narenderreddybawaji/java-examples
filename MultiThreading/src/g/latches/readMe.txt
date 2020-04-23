1. Use Case
	* We need to start our application
	* An AuthenticationService, DataService and an OrderService
	* Before serving clients, our application needs to make sure that several resources(e.g. above line) are properly initialized.
2. We can also use it or barrier in case when we wants to know runnable methods completed their execution or not.
3.  CountDownLatch vs CyclicBarrier
	3.1 In CountDownLatch, main threads waits for other threads to complete their execution(by adding await method in main class) 
	where as In CyclicBarrier, worker threads wait for each other to complete their execution (by adding method in each
	worker class).
	3.2 Cyclic barrier resets automatically once completed whereas count down latch does'nt reinitialize/reset. We can 
		reuse CyclicBarrier by calling reset() method which resets the barrier to its initial state
	  