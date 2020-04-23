1. CASing = Compare and Swap
2. Problem with synchronized, no real concurrency as it doesn't allow multiple threads to access data at same time.
	CAsing can improve this scenario.
3.  CASing with 3 parameters:
	3.1 a location in memory
	3.2 an existing value at the location
	3.3 a new value to replace this existing value
4. If the current value at that address is the expected value, then it is replaced by the new value and returns true.
 4.1 If thread tries to access value but value was modified, then current thread did not find value at address (so it
     can't modify its value) and return false.
5. CASing works well when concurrency is not "too" high. CASing tries many times until it is accepted
6. Atomic Variables using concept of CASing. Classes AtomicBoolean, AtomicInteger, AtomicReference etc
7. Address & Accumulators: This is introduced in JAVA 8.