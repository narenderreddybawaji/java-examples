1. Deadlock in multi-threading describes a situation where two or more threads are blocked forever, waiting for each other.
2. Deadlock in Java multi-threading environment may happen in case where-
    2.1 One synchronized method is called from another synchronized method.
    2.2 There are nested synchronized blocks.
3. Race Condition
	3.1 A race condition occurs when two or more threads can access shared data and they try to change it at the same time. 
	3.2 Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the threads will attempt to access the shared data.
	3.3 if (x == 5) // The "Check"
		{
		   y = x * 2; // The "Act"
		   // If another thread changed x in between "if (x == 5)" and "y = x * 2" above,
		   // y will not be equal to 10.
		}
	3.4 Use locks/synchronization to avoid race condition
		
