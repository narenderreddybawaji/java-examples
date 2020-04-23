1. Executor interface has only one method void execute (Runnable task)
	ExecutorService interface extends Executor with 10 more methods. Implementation of both interface are same.
2. Factory class Executors proposes ~20 methods to create executors
3. All threads created from Executors kept alive as long as pool alive. executorService.shutdown() to down pool.
4. Two most common used executors are:
	4.1 Single thread executor [Executors.newSingleThreadExecutor]- Only one thread in it. Very useful in reactive programming, when we want 
	just single task in another thread
	4.2 Fixed thread pool executor [Executors.newFixedThreadPool(<size>)]
5. Waiting Queue- Suppose we want to execute two task but pool size is one (Means one thread). \
	Then task 2 wait till task 1 execution completes. This waiting time is waiting queue.
6. Runnable functional interface has one method: void run();
