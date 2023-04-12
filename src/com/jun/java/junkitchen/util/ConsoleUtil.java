package com.jun.java.junkitchen.util;

import java.util.Scanner;

public class ConsoleUtil {
	private Scanner scanner;
	
	public ConsoleUtil() {
		this.scanner = new Scanner(System.in);
	}
	
	public String getValueOf(String label) {
		System.out.print(label + " : ");
		String inputStr = scanner.nextLine();
		inputStr = inputStr.trim(); 
		return inputStr;
	}
	
	public int getIntOf(String label) {
		System.out.print(label + " : ");
		String inputPrice = scanner.nextLine();
		int intPrice = Integer.parseInt(inputPrice);
		
		return intPrice; 
	}
}
