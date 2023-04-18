package main.java.kitchen.employee.display;

import java.util.Scanner;

public class Employee {
	private Scanner scanner;
	private EmployeeConsole empconsole;
	
	public Employee() {
		scanner = new Scanner(System.in);
		this.empconsole = new EmployeeConsole();
	}
	
	public void empMainScreen() {
		int inputNumber = 0;
		
		while(true) {
			displayMenu();
			inputNumber = selectMenu();
			
			switch (inputNumber) {
			case 1:
				empconsole.allEmp();
				break;
			case 2:
				empconsole.addEmp();
				break;
			case 3:
				empconsole.modifyEmp();
				break;
			case 4:
				empconsole.removeEmp();
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
		System.out.println("# 직원 관리");
		System.out.println("1. 현재 직원 현황");
		System.out.println("2. 직원 추가");
		System.out.println("3. 직원 수정");
		System.out.println("4. 직원 삭제");
		System.out.println("........................");
		System.out.println("0. 이전");
		System.out.println("........................");
	}
	
	public int selectMenu() {
		System.out.print("번호를 입력하세요: ");
		int empNumber = scanner.nextInt();
		if (empNumber >= 0 && empNumber <= 4) {
			scanner.nextLine();
			return empNumber;
		} else {
			return -1;
		}
	}
}
