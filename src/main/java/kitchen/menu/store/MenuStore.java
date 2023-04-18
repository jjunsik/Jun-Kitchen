package main.java.kitchen.menu.store;

import main.java.kitchen.menu.entity.MenuEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuStore {
	private final Map<String, MenuEntity> menuMap;

	public MenuStore() {
		this.menuMap =new HashMap<>();
	}

	public List<MenuEntity> retrieveAll() {
		return new ArrayList<>(this.menuMap.values());
	}

	public void create(MenuEntity menuEntity) {
		this.menuMap.put(menuEntity.getMenuName(), menuEntity);
	}

	public MenuEntity retrieve(String menuName){
		return this.menuMap.get(menuName);
	}

	public void update(MenuEntity updateMenu) {
		this.menuMap.put(updateMenu.getMenuName(), updateMenu);
	}

	public void delete(String menuName) {
		this.menuMap.remove(menuName);
	}
}
