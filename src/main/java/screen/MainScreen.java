package main.java.screen;

import java.util.Scanner;

import main.java.kitchen.employee.InitEmp;
import main.java.kitchen.employee.display.Employee;
import main.java.kitchen.menu.InitMenu;
import main.java.kitchen.menu.display.Menu;
import main.java.kitchen.revenue.display.Revenue;

public class MainScreen {
	private Scanner scanner;
	private Menu menu;
	private Employee emp;
	private Revenue rev;
	
	public MainScreen() {
		this.scanner = new Scanner(System.in);
		this.menu = new Menu();
		this.emp = new Employee();
		this.rev = new Revenue();
	}
	
	public void show() {
		int inputNumber = 0;
		InitMenu.set();
		InitEmp.set();
		
		while(true) {
			displayMainMenu();
			inputNumber = selectMainMenu();
			
			switch (inputNumber) {
			case 1:
				menu.menuMainScreen();
				break;
			case 2:
				emp.empMainScreen();
				break;
			case 3:
				rev.revMainScreen();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	private void displayMainMenu() {
		System.out.println("........................");
		System.out.println("행복한 가게 \"준식당\"");
		System.out.println("........................");
		System.out.println("1. 메뉴 관리");
		System.out.println("2. 직원 관리");
		System.out.println("3. 매출 확인");
		System.out.println("........................");
		System.out.println("0. 종료");
		System.out.println("........................");
	}
	
	private int selectMainMenu() {
		System.out.print("번호를 입력하세요: ");
		int mainmenuNumber = scanner.nextInt();
		if (mainmenuNumber >= 0 && mainmenuNumber <= 3) {
			scanner.nextLine();
			return mainmenuNumber;
		} else {
			return -1;
		}
	}
}
