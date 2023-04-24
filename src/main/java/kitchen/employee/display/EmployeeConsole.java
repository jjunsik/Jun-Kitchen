package main.java.kitchen.employee.display;

import java.util.Comparator;
import java.util.List;

import main.java.kitchen.employee.entity.EmployeeEntity;
import main.java.kitchen.employee.service.EmployeeService;
import main.java.kitchen.employee.service.EmployeeServiceLogicLifeCycle;
import main.java.kitchen.enums.EmpEnum;
import main.java.util.ConsoleUtil;
import main.java.util.ReplyUtil;

public class EmployeeConsole {
	private final ConsoleUtil consoleUtil;
	private final EmployeeService empService;
	private final ReplyUtil replyUtil;

	private final String enumSplit = ", ";

	public EmployeeConsole() {
		this.consoleUtil = ConsoleUtil.getInstance();
		this.empService = EmployeeServiceLogicLifeCycle.getUniqueInstance().getEmployeeService();
		this.replyUtil = ReplyUtil.getInstance();
	}

	public void allEmp() {
		List<EmployeeEntity> foundEmp = empService.findAll();
		foundEmp.sort(new Comparator<EmployeeEntity>() {
			@Override
			public int compare(EmployeeEntity o1, EmployeeEntity o2) {
				return o1.getEmpPeriod() - o2.getEmpPeriod();
			}
		});
		if(foundEmp.isEmpty()) {
			System.out.println("등록된 직원이 없습니다. 직원을 추가해주세요!");
			return;
		}

		for(EmployeeEntity empEntity : foundEmp) {
			System.out.println(empEntity.toString());
		}
	}

	public void addEmp() {
		while(true) {
			String empName = consoleUtil.getValueOf("직원 이름(" + replyUtil.getBackString() + ". 이전)");
			if(empName.equals(replyUtil.getBackString())) {
				return;
			}

			for(int i=0; i<empName.length(); i++) {
				if (String.valueOf(empName.charAt(i)).matches("[a-zA-Z0-9]")) {
					System.out.println("잘못된 입력입니다.");
					return;
				}
			}

			EmpEnum[] empEnums = EmpEnum.values();
			StringBuilder stringBuilder = new StringBuilder("직급(");
			for (EmpEnum empEnum : empEnums) {
				stringBuilder.append( empEnum.getRank() )
						.append( enumSplit );
			}
			String employeesString = stringBuilder.substring(0, stringBuilder.length()-2);
			String empJobString = consoleUtil.getValueOf(employeesString
					+ "("
					+ replyUtil.getBackString() + ". 이전))");

			if(replyUtil.isBack(empJobString)) {
				return;
			}

			boolean isEnum = false;
			EmpEnum empJob = null;
			for( EmpEnum empEnum : empEnums ) {
				if (empEnum.getRank().equals(empJobString)) {
					isEnum = true;
					empJob = empEnum;
					break;
				}
			}

			if ( !isEnum ){
				System.out.println("존재하지 않는 직급입니다.");
				return;
			}

			int empPeriod = consoleUtil.getIntOf("근무 시간(" + replyUtil.getBackInt() + ". 이전)");
			if(replyUtil.isBack(empPeriod)) {
				return;
			}

			String confirmStr = consoleUtil.getValueOf("추가(Y: 예, N: 아니오)").toLowerCase();
			if(replyUtil.checkIsYes(confirmStr)) {
				EmployeeEntity newEmp = new EmployeeEntity(empName, empJob, empPeriod);
				empService.addEmp(newEmp);
				System.out.println("직원이 추가되었습니다.\n" + newEmp);
			}else if(replyUtil.checkIsNo(confirmStr)){
				System.out.println("취소되었습니다.");
				return;
			}else{
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}
	}

	public void modifyEmp() {
		String empNo = consoleUtil.getValueOf("직원 번호(" + replyUtil.getBackString() + ". 이전)");
		if(replyUtil.isBack(empNo)) {
			return;
		}

		EmployeeEntity targetEmp = empService.findByNo(empNo);
		if(targetEmp == null) {
			System.out.println("존재하지 않는 직원입니다.");
			return;
		}

		System.out.println("수정 전 직원 정보 --> " + targetEmp);

		String newEmpName = consoleUtil.getValueOf("수정할 직원의 이름(" + replyUtil.getBackString() + ". 이전)");
		if(newEmpName.equals(replyUtil.getBackString())) {
			return;
		}
		if(newempname != null) {
			targetemp.setEmpName(newempname);
		}

		EmpEnum[] empEnums = EmpEnum.values();
		StringBuilder stringBuilder = new StringBuilder("수정할 직원의 직급\n--> ");
		for (EmpEnum empEnum : empEnums) {
			stringBuilder.append( empEnum.getRank() )
					.append( enumSplit );
		}
		String employeesString = stringBuilder.substring(0, stringBuilder.length()-2);
		String newEmpJob = consoleUtil.getValueOf(employeesString
				+ "("
				+ replyUtil.getBackString() + ". 이전))");

		if(newEmpJob.equals(replyUtil.getBackString())) {
			return;
		}

		int cnt = 0;
		for(EmpEnum empEnum : EmpEnum.values()) {
			if (empEnum.getRank().equals(newEmpJob)) {
				cnt += 1;
			}
		}

		if (cnt != 1){
			System.out.println("존재하지 않는 직급입니다.");
			return;
		}

		EmpEnum empJob = null;

		for (EmpEnum empEnum : empEnums) {
			if (empEnum.getRank().equals(newEmpJob)) {
				empJob = empEnum;
			}
		}
		
		empservice.modifyEmp(targetemp);
		
		System.out.println("수정된 직원 정보 --> " + targetemp.toString());
	}

	public void removeEmp() {
		String empNo = consoleUtil.getValueOf("직원 번호(" + replyUtil.getBackString() + ". 이전)");
		if(empNo.equals(replyUtil.getBackString())) {
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
