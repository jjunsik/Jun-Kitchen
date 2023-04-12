package com.jun.java.junkitchen.kitchenemployee;

public class EmployeeStoreLifeCycler {
	private static EmployeeStoreLifeCycler uniqueInstance;
	private EmployeeStore empstore;
	
	private EmployeeStoreLifeCycler() {
		this.empstore = new EmployeeStore();
	}
	
	public static EmployeeStoreLifeCycler getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmployeeStoreLifeCycler();
		}
		return uniqueInstance;
	}
	
	public EmployeeStore requestEmployeeStore() {
		return this.empstore;
	}
}
