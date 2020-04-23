package com;

public class Java8Tester {

	public static void main(String[] args) {
		Java8Tester java8Tester = new Java8Tester();

		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> a - b;
		MathOperation multiply = (a, b) -> {
			a = a + 1;
			return a * b;
		};

		System.err.println(java8Tester.operate(10, 5, addition));
		System.err.println(java8Tester.operate(10, 5, subtraction));
		System.err.println(java8Tester.operate(2, 2, multiply));
		GreetingService greetingService = (message) -> System.out.println("Hi" + message);
		greetingService.sayMessage("aaaaa");
	}

	@FunctionalInterface
	interface MathOperation {
		int operation(int a, int b);
	}

	@FunctionalInterface
	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
