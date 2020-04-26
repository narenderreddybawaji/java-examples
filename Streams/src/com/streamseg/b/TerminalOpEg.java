package com.streamseg.b;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOpEg {

	private void doIt() {
		List<String> memberNames = loadMemberNames();
		List<Employee> empList = loadEmpList();

		/* For Each */
		memberNames.forEach(System.out::println);

		/* collect */
		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.print(memNamesInUppercase);

		/* match */
		System.out.println("Match-");
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		// Print person obj who have 1111111 phone number (Set inside list)
		empList.stream().filter(res -> res.getPhone().stream().anyMatch(x -> x.contains("1111111")))
				.forEach(System.out::println);

		// Data Search
		System.out.println("Find First- Print first elemnt from list if exists");
		IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
		stream.findFirst().ifPresent(System.out::println);
		
		memberNames.stream().findFirst().ifPresent(System.out::println);

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
		TerminalOpEg eg = new TerminalOpEg();
		eg.doIt();
	}

}
