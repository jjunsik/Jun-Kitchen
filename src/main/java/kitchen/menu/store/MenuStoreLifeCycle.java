package main.java.kitchen.menu.store;

public class MenuStoreLifeCycle {
	private static MenuStoreLifeCycle uniqueInstance;
	private MenuStore menustore;
	
	private MenuStoreLifeCycle() {
		this.menustore = new MenuStore();
	}
	
	public static MenuStoreLifeCycle getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MenuStoreLifeCycle();
		}
		return uniqueInstance;
	}
	
	public MenuStore requestMenuStore() {
		return this.menustore;
	}

}
