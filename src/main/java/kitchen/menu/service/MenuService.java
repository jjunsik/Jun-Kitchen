package main.java.kitchen.menu.service;

import main.java.kitchen.menu.store.MenuStore;
import main.java.kitchen.menu.store.MenuStoreLifeCycle;
import main.java.kitchen.menu.entity.MenuEntity;

import java.util.List;

public class MenuService {
	private MenuStore menustore;
	
	public MenuService() {
		this.menustore = MenuStoreLifeCycle.getUniqueInstance().requestMenuStore();
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
