package main.java.kitchen.employee.store;

public class EmployeeStoreLifeCycle {
	private static EmployeeStoreLifeCycle uniqueInstance;
	private EmployeeStore empstore;
	
	private EmployeeStoreLifeCycle() {
		this.empstore = new EmployeeStore();
	}
	
	public static EmployeeStoreLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmployeeStoreLifeCycle();
		}
		return uniqueInstance;
	}
	
	public EmployeeStore requestEmployeeStore() {
		return this.empstore;
	}
}
