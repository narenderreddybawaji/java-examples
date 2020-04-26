package com.streamseg.b;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOpEg {

	/*
	 * Intermediate operations are further divided into stateless and stateful
	 * operations. (1) Stateless operations -> Retain no state from previous
	 * elements. (2) Stateful operations -> may incorporate state from
	 * previously seen elements when processing new elements
	 */
	private void doIt() {
		List<String> memberNames = loadMemberNames();
		List<Employee> empList = loadEmpList();

		System.out.println("========== Stateless =====================");
		/* Filter */
		// print members which starts with letter A
		System.out.println("Filter -- print members which starts with letter A");
		memberNames.stream().filter(res -> res.startsWith("A")).forEach(System.out::println);

		System.out.println("\nFilter -- print emp object whose salaray is greater than 50000 and name contains ABC4");
		empList.stream().filter(res -> res.getSalary() >= 50000).filter(res -> res.getEmpName().contains("ABC4"))
				.forEach(System.out::println);

		/* Map */
		// print members which starts with A in caps
		System.out.println("\nFilter, Map -- print members which starts with A in caps");
		memberNames.stream().filter(res -> res.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

		// print employee names in insertion order as it runs synchronously
		empList.stream().map(Employee::getEmpName).forEach(System.out::println);

		// print employee names without any order as it multiple threads runs
		// parallel
		empList.parallelStream().map(Employee::getEmpName).forEach(System.out::println);

		/* FlatMap */
		// empList.stream().map(Employee::getPhone).forEach(System.out::println);
		// -> It return phone number as set. (It return merges ph numbers)
		/*
		 * How flatMap() works : { {1,2}, {3,4}, {5,6} } -> flatMap ->
		 * {1,2,3,4,5,6} { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap ->
		 * {'a','b','c','d','e','f'}
		 */
		System.out.println("\nFlatMap: ");
		empList.stream().map(Employee::getPhone).flatMap(res -> res.stream()).forEach(System.out::println);

		System.out.println("\n========== Stateful =====================");
		/* Sorted */
		// print all members in caps sorted
		System.out.println("Sorted, Map -- print members which starts with A in caps");
		memberNames.stream().sorted().map(String::toUpperCase).forEach(res -> System.out.print(res + ", "));

		System.out.println("\nSorted, Map -- another way of writing. Print members which starts with A in caps");
		memberNames.stream().sorted().map(res -> res.toUpperCase()).forEach(res -> System.out.print(res + ", "));

		// print employee names in alphabetically sorted order
		System.out.println("\n\nSorted, Employee list");
		empList.stream().map(Employee::getEmpName).sorted().forEach(System.out::println);

		// print employee names without any order as we are using parallelStream
		// (although we have used sorted)
		System.out.println("Sort will not work with parallel stream");
		empList.parallelStream().map(Employee::getEmpName).sorted().forEach(System.out::println);

		// Sorting with comparator
		System.out.println("Sort names based on length using comparator");
		memberNames.stream().sorted((s1, s2) -> s2.length() - s1.length()).forEach(System.out::println);
	}

	private List<String> loadMemberNames() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Akshay");
		memberNames.add("Ranbeer");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		return memberNames;
	}

	private static List<Employee> loadEmpList() {
		Employee emp1 = new Employee(1, "ABC1", 50000, 25, Stream.of("1111111", "2222222").collect(Collectors.toSet()));
		Employee emp2 = new Employee(2, "ABC2", 10000, 27, Stream.of("2222222", "2222222").collect(Collectors.toSet()));
		Employee emp4 = new Employee(4, "ABC4", 70000, 35, Stream.of("1111111").collect(Collectors.toSet()));
		Employee emp3 = new Employee(3, "ABC3", 40000, 40, Stream.of("3333333").collect(Collectors.toSet()));
		Employee emp5 = new Employee(4, "ABC5", 72000, 35, Stream.of("1222221").collect(Collectors.toSet()));

		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);

		return empList;
	}

	public static void main(String[] args) {
		IntermediateOpEg eg = new IntermediateOpEg();
		eg.doIt();
	}

}
