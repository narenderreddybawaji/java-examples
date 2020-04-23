package com.defaultfunction;

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	/*@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
	}*/

	@Override
	public void log(String str) {
		Interface1.super.log(str);
	}

	public static void main(String[] args) {
		// Note if you don't override log function. then compile time error
		// occur, as both inetrfaces have log as default function and to avoid
		// diamond problem compile time error appears.
		MyClass myClass = new MyClass();
		myClass.log("aaa");
	}

}
