package com.jun.java.junkitchen.kitchenemployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStore {
	private Map<String, EmployeeEntity> empmap;
	
	public EmployeeStore() {
		this.empmap =new HashMap<>();
	}
	
	public List<EmployeeEntity> retrieveAll() {
		return new ArrayList<>(this.empmap.values());
	}
	
	public void create(EmployeeEntity empentity) {
		this.empmap.put(empentity.getEmpNo(), empentity);
	}
	
	public EmployeeEntity retrieve(String empNo){
		return this.empmap.get(empNo);
	}

	public void update(EmployeeEntity updateEmp) {
		this.empmap.put(updateEmp.getEmpNo(), updateEmp);
	}
	
	public void delete(String empNo) {
		this.empmap.remove(empNo);
	}
}
