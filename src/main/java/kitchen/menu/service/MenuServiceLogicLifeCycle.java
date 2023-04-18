package main.java.kitchen.menu.service;

public class MenuServiceLogicLifeCycle {
	private static MenuServiceLogicLifeCycle uniqueInstance;
	private MenuService menuservice;
	
	private MenuServiceLogicLifeCycle() {
		this.menuservice = new MenuService();
	}
	
	public static MenuServiceLogicLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MenuServiceLogicLifeCycle();
		}
		return uniqueInstance;
	}
	
	public MenuService getMenuService() {
		return this.menuservice;
	}
}
