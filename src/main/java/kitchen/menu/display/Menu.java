package main.java.kitchen.menu.display;

import java.util.Scanner;

public class Menu {
	private Scanner scanner;
	private MenuConsole menuconsole;
	
	public Menu() {
		scanner = new Scanner(System.in);
		this.menuconsole = new MenuConsole();
	}

	public void menuMainScreen() {
		int inputNumber;

		while (true) {
			displayMenu();
			inputNumber = selectMenu();

			switch (inputNumber) {
				case 1:
					menuConsole.allMenu();
					break;
				case 2:
					menuConsole.addMenu();
					break;
				case 3:
					menuConsole.modifyMenu();
					break;
				case 4:
					menuConsole.removeMenu();
					break;
				case 0:
					return;
				default:
					System.out.println("다시 입력해주세요.");
			}
		}

	}
	
	public void displayMenu() {
		System.out.println("........................");
		System.out.println("# 메뉴 관리");
		System.out.println("1. 현재 메뉴 확인");
		System.out.println("2. 메뉴 추가");
		System.out.println("3. 메뉴 수정");
		System.out.println("4. 메뉴 삭제");
		System.out.println("........................");
		System.out.println("0. 이전");
		System.out.println("........................");
	}
	
	public int selectMenu() {
		System.out.print("번호를 입력하세요: ");
		int menuNumber = scanner.nextInt();
		if (menuNumber >= 0 && menuNumber <= 4) {
			scanner.nextLine();
			return menuNumber;
		} else {
			return -1;
		}
	}

}
