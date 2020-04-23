package com.custom.class_;

public class MainClass {
	public static void main(String[] args) {
		MyInterface myI = (nm) -> {
			return "Welcome " + nm;
		};
		
		System.out.println(myI.greeting("Dhairu"));

	}
}
