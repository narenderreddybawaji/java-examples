1. Callable vs Executor
	1.1 A task in executor does not return anything (no objects, no execption to move forward)
	1.2 There is no way to know task is done or not
2. Callable functional interface has method: V call() throws Exception;
3. future.get(): The get() call is blocking until the returned value is available
4. executorService.submit(Callable): Returns Future<Callable_Type>
4. executorService.invokeAll(<Callable Collection>): 
	4.1 We can submit multiple callable requests (insteading passing submit function multiple times). 
	4.2 It returns List<Future<Callable_Type>>
