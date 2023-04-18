package main.java.kitchen.menu.service;

import main.java.kitchen.menu.store.MenuStore;
import main.java.kitchen.menu.store.MenuStoreLifeCycle;
import main.java.kitchen.menu.entity.MenuEntity;

import java.util.List;

public class MenuService {
	private final MenuStore menuStore;

	public MenuService() {
		this.menuStore = MenuStoreLifeCycle.getUniqueInstance().requestMenuStore();
	}

	public List<MenuEntity> findAll() {
		return this.menuStore.retrieveAll();
	}

	public void addMenu(MenuEntity newMenu) {
		this.menuStore.create(newMenu);
	}

	public MenuEntity findByName(String menuName) {
		return this.menuStore.retrieve(menuName);
	}

	public void modifyMenu(MenuEntity modifyMenu) {
		this.menuStore.update(modifyMenu);
	}

	public void removeMenu(String menuName) {
		this.menuStore.delete(menuName);
	}
}
