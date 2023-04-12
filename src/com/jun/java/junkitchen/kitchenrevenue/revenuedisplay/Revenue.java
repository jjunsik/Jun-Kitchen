package com.jun.java.junkitchen.kitchenrevenue.revenuedisplay;

import com.jun.java.junkitchen.kitchenrevenue.RevenueEntity;
import java.util.Scanner;

public class Revenue {
	private Scanner scanner;
	private RevenueEntity rev;
	
	public Revenue() {
		scanner = new Scanner(System.in);
		rev = new RevenueEntity();
	}
	
	public void revMainScreen() {
		displayMenu();
		System.out.print("이전 화면으로 가려면 0번을 입력하세요.\n입력: ");
		while(true) {
			int revNumber = scanner.nextInt();
			scanner.nextLine();
			
			if (revNumber == 0) {
				return;
			} else {
				System.out.print("다시 입력해주세요.\n입력: ");
			}
		}
	}
	
	public void displayMenu() {
		System.out.println("........................");
		rev.allmenuRev();
		System.out.println("........................");
	}
}
