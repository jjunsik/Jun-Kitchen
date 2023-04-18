package main.java.kitchen.employee.service;

public class EmployeeServiceLogicLifeCycle {
	private static EmployeeServiceLogicLifeCycle uniqueInstance;
	private EmployeeService empservice;
	
	private EmployeeServiceLogicLifeCycle() {
		this.empservice = new EmployeeService();
	}
	
	public static EmployeeServiceLogicLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmployeeServiceLogicLifeCycle();
		}
		return uniqueInstance;
	}
	
	public EmployeeService getEmployeeService() {
		return this.empservice;
	}
}
