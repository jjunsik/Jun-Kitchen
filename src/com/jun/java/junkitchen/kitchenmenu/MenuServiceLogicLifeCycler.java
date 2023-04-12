package com.jun.java.junkitchen.kitchenmenu;

public class MenuServiceLogicLifeCycler {
	private static MenuServiceLogicLifeCycler uniqueInstance;
	private MenuService menuservice;
	
	private MenuServiceLogicLifeCycler() {
		this.menuservice = new MenuService();
	}
	
	public static MenuServiceLogicLifeCycler getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MenuServiceLogicLifeCycler();
		}
		return uniqueInstance;
	}
	
	public MenuService getMenuService() {
		return this.menuservice;
	}
}
