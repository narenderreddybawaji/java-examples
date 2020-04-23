1. Semaphore is normally non-fair, that means any thread can access w/o order. Fair means if multiple threads wants to acquire and semaphore is available 
	then it will allocated first to thread which comes first in queue.
2. Semaphore sema = new Semaphore(5); // Means it permit only five threads can access simultaneously
3. Semaphore sema = new Semaphore(5,true); // Can be made fair if Passing true
4. This api has been build as the same idea of lock.
5. One can reduce the number of permits (cannot increase it)
6. Features more than lock
	6.1 Lock can provide only one permit but semaphore can permit one or more
	6.2 Can check any thread waiting?
	6.3 How many threads are waiting?
	6.4 Get collection of waiting thread
7. Project Implementation: In our project, problem occurs when we set time time of cron job to every minute to process
	task. As task consumes large memory & multiple thread executing same task lead to out of memory.
	As per business requirement, we can skip thread/cron if one is already in process. So we have use semaphore.
 
