## 준식당
```java
MainScreen.java - show()
InitMenu.set(); # 기본 메뉴들
InitEmp.set(); # 기본 직원들

MenuConsole.java - allMenu()
        
# 메뉴 가격에 따라 카테고리별로 정렬
foundmenus.sort((m1, m2) -> ((Integer) m1.getMenuPrice()).compareTo(m2.getMenuPrice()));
if(menuentity.getCategory().equals("한식"))
if(menuentity.getCategory().equals("양식"))
if(menuentity.getCategory().equals("중식"))
if(menuentity.getCategory().equals("일식"))

EmployeeConsole.java - allEmp()
# 근무 기간에 따라 정렬
foundemps.sort((m1, m2) -> ((Integer)m1.getEmpPeriod()).compareTo(m2.getEmpPeriod()));
    
EmployeeEntity.java - 생성자
# 직원 별로 랜덤값의 직원 번호 부여
this.empNo = UUID.randomUUID().toString();


```

