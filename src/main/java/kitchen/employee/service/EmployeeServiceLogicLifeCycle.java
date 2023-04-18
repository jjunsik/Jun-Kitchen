package main.java.kitchen.employee.service;

public class EmployeeServiceLogicLifeCycle {
	private static EmployeeServiceLogicLifeCycle uniqueInstance;
	private final EmployeeService empService;

	private EmployeeServiceLogicLifeCycle() {
		this.empService = new EmployeeService();
	}

	public static EmployeeServiceLogicLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmployeeServiceLogicLifeCycle();
		}
		return uniqueInstance;
	}

	public EmployeeService getEmployeeService() {
		return this.empService;
	}
}
