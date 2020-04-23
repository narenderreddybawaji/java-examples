package com;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.forEach(res -> System.out.println(res));
		list.forEach(System.out::println);
	}

}
