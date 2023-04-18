package main.java.kitchen.employee.service;

import main.java.kitchen.employee.store.EmployeeStore;
import main.java.kitchen.employee.store.EmployeeStoreLifeCycle;
import main.java.kitchen.employee.entity.EmployeeEntity;

import java.util.List;

public class EmployeeService {
	private final EmployeeStore empStore;

	public EmployeeService() {
		this.empStore = EmployeeStoreLifeCycle.getUniqueInstance().requestEmployeeStore();
	}

	public List<EmployeeEntity> findAll() {
		return this.empStore.retrieveAll();
	}

	public void addEmp(EmployeeEntity newEmp) {
		this.empStore.create(newEmp);
	}

	public EmployeeEntity findByNo(String empNo) {
		return this.empStore.retrieve(empNo);
	}

	public void modifyEmp(EmployeeEntity modifyEmp) {
		this.empStore.update(modifyEmp);
	}

	public void removeEmp(String empNo) {
		this.empStore.delete(empNo);
	}
}
