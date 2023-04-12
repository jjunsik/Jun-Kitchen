package com.jun.java.junkitchen.kitchenmenu;

import java.util.List;

public class MenuService {
	private MenuStore menustore;
	
	public MenuService() {
		this.menustore = MenuStoreLifeCycler.getUniqueInstance().requestMenuStore();
	}
	
	public List<MenuEntity> findAll() {
		return this.menustore.retrieveAll();
	}

	public void addMenu(MenuEntity newmenu) {
		this.menustore.create(newmenu);
	}
	
	public MenuEntity findByName(String menuname) {
		return this.menustore.retrieve(menuname);
	}

	public void modifyMenu(MenuEntity modifymenu) {
		this.menustore.update(modifymenu);
	}
	
	public void removeMenu(String menuname) {
		this.menustore.delete(menuname);
	}
}
