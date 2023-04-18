package main.java.kitchen.employee.store;

import main.java.kitchen.employee.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStore {
	private final Map<String, EmployeeEntity> empMap;

	public EmployeeStore() {
		this.empMap =new HashMap<>();
	}

	public List<EmployeeEntity> retrieveAll() {
		return new ArrayList<>(this.empMap.values());
	}

	public void create(EmployeeEntity empEntity) {
		this.empMap.put(empEntity.getEmpNo(), empEntity);
	}

	public EmployeeEntity retrieve(String empNo){
		return this.empMap.get(empNo);
	}

	public void update(EmployeeEntity updateEmp) {
		this.empMap.put(updateEmp.getEmpNo(), updateEmp);
	}

	public void delete(String empNo) {
		this.empMap.remove(empNo);
	}
}
