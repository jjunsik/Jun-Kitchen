package main.java.kitchen.employee.entity;

import java.util.UUID;

public class EmployeeEntity {
	private String empName;
	private String empNo;
	private String empJob;
	private int empPeriod;
	
	public EmployeeEntity(String empName, String empJob, int empPeriod) {
		setEmpName(empName);
		this.empNo = UUID.randomUUID().toString();
		setEmpJob(empJob);
		setEmpPeriod(empPeriod);
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	
	public int getEmpPeriod() {
		return empPeriod;
	}
	public void setEmpPeriod(int empPeriod) {
		this.empPeriod = empPeriod;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("직원명 : ").append(empName);
		builder.append(", 직원 번호 : ").append(empNo);
		builder.append(", 직급 : ").append(empJob);
		builder.append(", 근무 시간 : ").append(empPeriod).append("시간");
	
		return builder.toString();
	}
}
