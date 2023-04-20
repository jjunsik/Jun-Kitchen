package main.java.kitchen.employee.display;

import main.java.util.ConsoleManager;

import java.util.Scanner;

public class Employee extends ConsoleManager {
	private final EmployeeConsole empConsole;

	public Employee() {
		super(new Scanner(System.in));
		this.empConsole = new EmployeeConsole();
	}

	public void empMainScreen() {
		int inputNumber;

		while(true) {
			displayMenu();
			inputNumber = selectMenu();

			switch (inputNumber) {
				case 1:
					empConsole.allEmp();
					break;
				case 2:
					empConsole.addEmp();
					break;
				case 3:
					empConsole.modifyEmp();
					break;
				case 4:
					empConsole.removeEmp();
					break;
				case 0:
					return;
				default:
					System.out.println("다시 입력해주세요.");
			}
		}

	}

	private void displayMenu() {
		displayStart("# 직원 관리");
		System.out.println("1. 현재 직원 현황");
		System.out.println("2. 직원 추가");
		System.out.println("3. 직원 수정");
		System.out.println("4. 직원 삭제");
		displayEnd("0. 이전");
	}

	private int selectMenu() {
		return select(0, 4);
	}

}
