package main.java.kitchen.employee.store;

public class EmployeeStoreLifeCycle {
	private static EmployeeStoreLifeCycle uniqueInstance;
	private final EmployeeStore empStore;

	private EmployeeStoreLifeCycle() {
		this.empStore = new EmployeeStore();
	}

	public static EmployeeStoreLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmployeeStoreLifeCycle();
		}
		return uniqueInstance;
	}

	public EmployeeStore requestEmployeeStore() {
		return this.empStore;
	}
}
