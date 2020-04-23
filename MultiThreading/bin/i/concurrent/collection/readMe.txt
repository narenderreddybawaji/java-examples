1. Vectors and Stacks are thread safe. They are legacy structures and very poorly implemented. It internally uses synchronized which is not good for performance.
2. 
3. Copy on Write structure:
	3.1 Exists for lists and sets (CopyOnWriteArrayList & CopyOnWriteArraySet) 
	3.2 No locking for read operation
	3.3 Write operation create a new structure. This new structure then replaces the previous one.
	3.4 Work well when there are many reads & very,very few writes
4. Queues
	4.1 Interfaces: Queue, Deque(Double ended queue)
	4.2 Implementation: 
		4.2.1 ArrayBlockingQueue: Bounded blocking queue. Once queue is full, it can add more elements automatically.
		4.2.2 ConcurrentLinkedQueue: Unbounded blocking queue. We can add elements as many as wants.
	4.3 Blocking queue 
		4.3.1 Can be used in producer/consumer, it can block until queue can add/remove elements. 
		4.3.2 put() to add value and wait if queue is fully, 
		4.3.3 take() to retrieve & remove value & wait if queue is empty whereas peek() to retrieve value & wait if queue is empty
	4.4 Deque
		4.4.1 Can be use as queue(FIFO) or stack(LIFO) by accessing from tail/head
		4.4.2 Can accept elements at the head of queue: addFirst(), offerFirst(), putFirst()

	  