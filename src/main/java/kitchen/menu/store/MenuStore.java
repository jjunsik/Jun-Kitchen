package main.java.kitchen.menu.store;

import main.java.kitchen.menu.entity.MenuEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuStore {
	private Map<String, MenuEntity> menumap;
	
	public MenuStore() {
		this.menumap =new HashMap<>();
	}
	
	public List<MenuEntity> retrieveAll() {
		return new ArrayList<>(this.menumap.values());
	}
	
	public void create(MenuEntity menuentity) {
		this.menumap.put(menuentity.getMenuName(), menuentity);
	}
	
	public MenuEntity retrieve(String menuname){
		return this.menumap.get(menuname);
	}

	public void update(MenuEntity updatemenu) {
		this.menumap.put(updatemenu.getMenuName(), updatemenu);
	}
	
	public void delete(String menuname) {
		this.menumap.remove(menuname);
	}
}
