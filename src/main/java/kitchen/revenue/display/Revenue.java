package main.java.kitchen.revenue.display;

import main.java.kitchen.revenue.entity.RevenueEntity;
import main.java.util.ReplyUtil;

import java.util.Scanner;

public class Revenue {
	private final Scanner scanner;
	private final RevenueEntity revEntity;
	private final ReplyUtil replyUtil;

	public Revenue() {
		scanner = new Scanner(System.in);
		revEntity = new RevenueEntity();
		replyUtil = new ReplyUtil();
	}

	public void revMainScreen() {
		displayMenu();
		System.out.print("이전 화면으로 가려면 "+ replyUtil.getBackInt() +"번을 입력하세요.\n입력: ");
		while(true) {
			int revNumber = scanner.nextInt();
			scanner.nextLine();

			if (replyUtil.isBack(revNumber)) {
				return;
			} else {
				System.out.print("다시 입력해주세요.\n입력: ");
			}
		}
	}

	public void displayMenu() {
		System.out.println("........................");
		revEntity.allMenuRev();
		System.out.println("........................");
	}
}
