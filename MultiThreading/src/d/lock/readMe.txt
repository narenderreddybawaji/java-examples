1. Lock is used to replace synchronized
2. Lock is interface and ReentrantLock is the implementation class
3. It offers same guarantees (exclusion, read & write ordering) as synchronized. Better than synchronized as it
	has multiple methods we can use.
4. Lock patterns
	4.1 Interrupted: possible but hard & costly
	4.2 Time Lock Acquisition: It can be blocked for a set amount of time
	4.3 Fair lock Acquisition: It can be fair, letting in threads on a first come first serve basis. costly (must be avoided)
	 
