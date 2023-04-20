package main.java.kitchen.menu.display;

import main.java.util.ConsoleManager;

import java.util.Scanner;

public class Menu extends ConsoleManager {

	private final MenuConsole menuConsole;

	public Menu() {
		super(new Scanner(System.in));
		this.menuConsole = new MenuConsole();
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

	private void displayMenu() {
		displayStart("# 메뉴 관리");
		System.out.println("1. 현재 메뉴 확인");
		System.out.println("2. 메뉴 추가");
		System.out.println("3. 메뉴 수정");
		System.out.println("4. 메뉴 삭제");
		displayEnd("0. 이전");
	}

	private int selectMenu() {
		return select(0, 4);
	}
}
