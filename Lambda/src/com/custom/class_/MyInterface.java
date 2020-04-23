package com.custom.class_;

// Writing @FunctionalInterface annotation is not mandatory. But if we create more then one abstract method, main class
// will throw compile time exception
@FunctionalInterface
public interface MyInterface {
	
	String greeting(String name);
}
