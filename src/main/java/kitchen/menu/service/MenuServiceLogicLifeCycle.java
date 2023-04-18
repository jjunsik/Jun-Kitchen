package main.java.kitchen.menu.service;

public class MenuServiceLogicLifeCycle {
	private static MenuServiceLogicLifeCycle uniqueInstance;
	private final MenuService menuService;

	private MenuServiceLogicLifeCycle() {
		this.menuService = new MenuService();
	}

	public static MenuServiceLogicLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MenuServiceLogicLifeCycle();
		}
		return uniqueInstance;
	}

	public MenuService getMenuService() {
		return this.menuService;
	}
}
