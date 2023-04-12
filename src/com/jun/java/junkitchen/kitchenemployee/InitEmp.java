package com.jun.java.junkitchen.kitchenemployee;

public class InitEmp {
	public static EmployeeService empservice = EmployeeServiceLogicLifeCycler.getUniqueInstance().getEmployeeService();
	
	public static void set() {
		EmployeeEntity emp1 = new EmployeeEntity("황준식", "인턴", 150);
		EmployeeEntity emp2 = new EmployeeEntity("최혁재", "사원", 500);
		EmployeeEntity emp3 = new EmployeeEntity("김수빈", "사원", 600);
		EmployeeEntity emp4 = new EmployeeEntity("이창재", "대리", 1000);
		EmployeeEntity emp5 = new EmployeeEntity("김홍빈", "대리", 1200);
		EmployeeEntity emp6 = new EmployeeEntity("이동혁", "과장", 5000);
		
		empservice.addEmp(emp1);
		empservice.addEmp(emp2);
		empservice.addEmp(emp3);
		empservice.addEmp(emp4);
		empservice.addEmp(emp5);
		empservice.addEmp(emp6);
	}

}
