package com.jun.java.junkitchen.kitchenmenu;

public class MenuStoreLifeCycler {
	private static MenuStoreLifeCycler uniqueInstance;
	private MenuStore menustore;
	
	private MenuStoreLifeCycler() {
		this.menustore = new MenuStore();
	}
	
	public static MenuStoreLifeCycler getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MenuStoreLifeCycler();
		}
		return uniqueInstance;
	}
	
	public MenuStore requestMenuStore() {
		return this.menustore;
	}

}
