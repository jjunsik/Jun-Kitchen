package main.java.kitchen.enums;

public enum EmpEnum {
    CEO("최고 경영자"), PRESIDENT("사장"), GENERAL("부장"), DEPUTY("차장"), MANAGER("과장"),
    ASSISTANT("대리"), SENIOR("주임"), CLERK("사원");

    private final String rank;

    EmpEnum(String rank){
        this.rank = rank;
    }

    public String getRank(){
        return this.rank;
    }
}
