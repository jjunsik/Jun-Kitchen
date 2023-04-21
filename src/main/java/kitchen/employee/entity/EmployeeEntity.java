package main.java.kitchen.employee.entity;

import main.java.kitchen.enums.EmpEnum;

import java.util.UUID;

public class EmployeeEntity {
	private String empName;
	private final String empNo;
	private EmpEnum empJob;
	private int empPeriod;

	public EmployeeEntity(String empName, EmpEnum empJob, int empPeriod) {
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

	public void setEmpJob(EmpEnum empJob) {
		this.empJob = empJob;
	}

	public int getEmpPeriod() {
		return empPeriod;
	}
	public void setEmpPeriod(int empPeriod) {
		this.empPeriod = empPeriod;
	}

	public String toString() {

		return "직원명 : " + empName +
				", 직원 번호 : " + empNo +
				", 직급 : " + empJob.getRank() +
				", 근무 시간 : " + empPeriod + "시간";
	}
}
