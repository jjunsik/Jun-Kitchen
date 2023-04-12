package com.jun.java.junkitchen.kitchenemployee;

public class EmployeeServiceLogicLifeCycler {
	private static EmployeeServiceLogicLifeCycler uniqueInstance;
	private EmployeeService empservice;
	
	private EmployeeServiceLogicLifeCycler() {
		this.empservice = new EmployeeService();
	}
	
	public static EmployeeServiceLogicLifeCycler getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmployeeServiceLogicLifeCycler();
		}
		return uniqueInstance;
	}
	
	public EmployeeService getEmployeeService() {
		return this.empservice;
	}
}
