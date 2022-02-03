package com.sapinet.flixme.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardUtil {
	
	private KeyboardUtil() {}
	
	public static int getInt(String message) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}
	
	public static String getString(String message) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	public static double getDouble(String message) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}
	
	public static Date getDate(String message) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		String input=sc.nextLine();
		String format= "dd/MM/yyyy";
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(input);
			
		} catch (Exception e) {
			throw new InputMismatchException(e.getMessage());
		}
		
	}
	

}
