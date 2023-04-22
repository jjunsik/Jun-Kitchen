package main.java.kitchen.employee;

import main.java.kitchen.employee.entity.EmployeeEntity;
import main.java.kitchen.employee.service.EmployeeService;
import main.java.kitchen.employee.service.EmployeeServiceLogicLifeCycle;
import main.java.kitchen.enums.EmpEnum;

public class InitEmp {
	public static final EmployeeService empService = EmployeeServiceLogicLifeCycle.getUniqueInstance().getEmployeeService();

	public static void set() {

		String[] names = new String[]{
				"황준식", "최혁재", "김수빈", "이창재", "김홍빈", "이동혁"
		};

		EmpEnum[] enums = new EmpEnum[]{
				EmpEnum.CLERK, EmpEnum.SENIOR, EmpEnum.ASSISTANT, EmpEnum.MANAGER, EmpEnum.DEPUTY, EmpEnum.GENERAL
		};

		Integer[] periods = new Integer[]{
				150, 500, 600, 1000, 1200, 5000
		};

		for (int i=0;i<names.length;i++){
			EmployeeEntity emp = new EmployeeEntity(names[i], enums[i], periods[i]);
			empService.addEmp(emp);
		}
	}
}
