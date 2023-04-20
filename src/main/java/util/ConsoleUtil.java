package main.java.util;

import java.util.Scanner;

public class ConsoleUtil {
	private final Scanner scanner;
	private static ConsoleUtil consoleUtil;

	private ConsoleUtil() {
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

		return Integer.parseInt(inputPrice);
	}

	public static ConsoleUtil getInstance() {
		if (consoleUtil == null) {
			consoleUtil = new ConsoleUtil();
		}
		return consoleUtil;
	}
}
