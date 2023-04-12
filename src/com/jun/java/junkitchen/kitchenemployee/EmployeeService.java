package com.jun.java.junkitchen.kitchenemployee;

import java.util.List;

public class EmployeeService {
	private EmployeeStore empstore;
	
	public EmployeeService() {
		this.empstore = EmployeeStoreLifeCycler.getUniqueInstance().requestEmployeeStore();
	}
	
	public List<EmployeeEntity> findAll() {
		return this.empstore.retrieveAll();
	}

	public void addEmp(EmployeeEntity newemp) {
		this.empstore.create(newemp);
	}
	
	public EmployeeEntity findByNo(String empno) {
		return this.empstore.retrieve(empno);
	}

	public void modifyEmp(EmployeeEntity modifyemp) {
		this.empstore.update(modifyemp);
	}
	
	public void removeEmp(String empno) {
		this.empstore.delete(empno);
	}
}
