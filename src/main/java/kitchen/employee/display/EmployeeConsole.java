package main.java.kitchen.employee.display;

import java.util.List;

import main.java.kitchen.employee.entity.EmployeeEntity;
import main.java.kitchen.employee.service.EmployeeService;
import main.java.kitchen.employee.service.EmployeeServiceLogicLifeCycle;
import main.java.util.ConsoleUtil;

public class EmployeeConsole {
	private ConsoleUtil consoleutil;
	private EmployeeService empservice;
	
	public EmployeeConsole() {
		this.consoleutil = new ConsoleUtil();
		this.empservice = EmployeeServiceLogicLifeCycle.getUniqueInstance().getEmployeeService();
	}

	public void allEmp() {
		List<EmployeeEntity> foundemps = empservice.findAll();
		foundemps.sort((m1, m2) -> ((Integer)m1.getEmpPeriod()).compareTo(m2.getEmpPeriod()));
		
		if(foundemps.isEmpty()) {
			System.out.println("등록된 직원이 없습니다. 직원을 추가해주세요!");
			return;
		}

		for(EmployeeEntity empEntity : foundEmp) {
			System.out.println(empEntity.toString());
		}
	}

	public void addEmp() {
		while(true) {
			String empname = consoleutil.getValueOf("직원 이름(0. 이전) ");
			if(empname.equals("0")) {
				return;
			}
			
			String empjob = consoleutil.getValueOf("직급(0. 이전) ");
			if(empjob.equals("0")) {
				return;
			}
			
			int empperiod = consoleutil.getIntOf("근무 시간(0. 이전) ");
			if(empperiod == 0) {
				return;
			}
			
			EmployeeEntity newemp = new EmployeeEntity(empname, empjob, empperiod);
			empservice.addEmp(newemp);
			System.out.println("직원이 추가되었습니다.\n" + newemp.toString());
		}
	}

	public void modifyEmp() {
		String empno = consoleutil.getValueOf("직원 번호(0. 이전)");
		if(empno.equals("0")) {
			return;
		}

		EmployeeEntity targetEmp = empService.findByNo(empNo);
		if(targetEmp == null) {
			System.out.println("존재하지 않는 직원입니다.");
			return;
		}
		
		System.out.println("수정 전 직원 정보 --> " + targetemp/*.toString()*/);
		
		String newempname = consoleutil.getValueOf("수정할 직원의 이름(0. 이전)");
		if(newempname.equals("0")) {
			return;
		}
		if(newempname != null) {
			targetemp.setEmpName(newempname);
		}
		
		String newempjob = consoleutil.getValueOf("수정할 직원의 직급(0. 이전)");
		if(newempjob.equals("0")) {
			return;
		}
		if(newempjob != null) {
			targetemp.setEmpJob(newempjob);
		}
		
		Integer newempperiod = consoleutil.getIntOf("수정할 직원의 근무시간(0. 이전)");
		if(newempperiod.equals(0)) {
			return;
		}
		if(newempperiod != null) {
			targetemp.setEmpPeriod(newempperiod);
		}
		
		empservice.modifyEmp(targetemp);
		
		System.out.println("수정된 직원 정보 --> " + targetemp.toString());
	}

	public void removeEmp() {
		String empno = consoleutil.getValueOf("직원 번호(0. 이전)");
		if(empno.equals("0")) {
			return;
		}

		EmployeeEntity targetEmp = empService.findByNo(empNo);
		if(targetEmp == null) {
			System.out.println("존재하지 않는 직원입니다.");
			return;
		}
		
		String confirmstr = consoleutil.getValueOf("이 직원을 삭제하시겠습니까?(Y: 예, N: 아니오)");
		if(confirmstr.toLowerCase().equals("y")) {
			System.out.println("직원 정보가 삭제되었습니다.\n삭제된 직원 --> " + targetemp);
			empservice.removeEmp(targetemp.getEmpNo());
		}else {
			System.out.println("삭제를 취소했습니다.");
		}
	}

}
