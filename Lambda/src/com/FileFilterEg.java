package com;

import java.io.File;
import java.io.FileFilter;


public class FileFilterEg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("==========================");
		FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.getName().endsWith("java");
			}
		};
		System.err.println(fileFilter.accept(new File("axx.java")));
		
		FileFilter fileFilterLambda = (File pathname) -> pathname.getName().endsWith("java");
		System.err.println(fileFilterLambda.accept(new File("axx.java")));
	}

}
