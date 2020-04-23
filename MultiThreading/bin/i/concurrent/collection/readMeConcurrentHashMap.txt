ConcurrentMap
---------------
1. Interface: ConcurrentMap
2. This class obeys the same functional specification as Hashtable
3. Like Hashtable but unlike HashMap, this class does not allow null to be used as a key or value
4. ConcurrentHashMap allows multiple readers to read concurrently without any blocking.
5. This is achieved by partitioning Map into different parts based on concurrency level and locking only a portion of Map during updates.
	Default concurrency level is 16, and accordingly Map is divided into 16 part(segment) and each part is governed with a different lock. 
	This means, 16 thread can operate on Map simultaneously until they are operating on different part of Map.
	Here 16 means 16 buckets, & lock apply to bucket where we want to write something (irrespective position of list in bucket).
6. Each portion of map is Segment. ConcurrentHashMap also uses ReentrantLock to internally lock its segments.
7. Java8- 
	7.1 Can be used for parallel search/map/reduce/for each
	7.2 It can handle millions of key/value pairs in concurrency
	7.3 We can create Concurrent Sets using ConcurrentHashMap in Java8
			Set<String> set = ConcurrentHashMap.<String>newKetSet(); But it doesn't allow parallel operations.
			
http://javabypatel.blogspot.com/2016/09/concurrenthashmap-interview-questions.html