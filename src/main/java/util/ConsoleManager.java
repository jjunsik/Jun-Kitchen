package main.java.util;

import java.util.Scanner;

public class ConsoleManager {
    private final Scanner scanner;

    public ConsoleManager (Scanner scanner) {
        this.scanner = scanner;
    }

    protected void displayStart (String startString) {
        System.out.println("........................");
        System.out.println(startString);
    }

    protected void displayEnd (String endString) {
        System.out.println("........................");
        System.out.println(endString);
        System.out.println("........................");
    }

    protected int select(int start, int end) {
        System.out.print("번호를 입력하세요: ");
        int number = scanner.nextInt();
        if (number >= start && number <= end) {
            scanner.nextLine();
            return number;
        } else {
            return -1;
        }
    }
}
