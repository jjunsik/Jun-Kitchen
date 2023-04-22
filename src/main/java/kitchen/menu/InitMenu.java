package main.java.kitchen.menu;

import main.java.kitchen.menu.entity.MenuEntity;
import main.java.kitchen.menu.store.MenuStore;
import main.java.kitchen.menu.store.MenuStoreLifeCycle;

public class InitMenu {
	private static final MenuStore menuStore = MenuStoreLifeCycle.getUniqueInstance().requestMenuStore();

	public static void set() {

		MenuEntity menu1 = new MenuEntity("불고기", 15000, "한식", ran1);
		MenuEntity menu2 = new MenuEntity("파스타", 17000, "양식", ran2);
		MenuEntity menu3 = new MenuEntity("비빔밥", 13000, "한식", ran3);
		MenuEntity menu4 = new MenuEntity("피자", 20000, "양식", ran4);
		MenuEntity menu5 = new MenuEntity("삼겹살", 16000, "한식", ran5);
		MenuEntity menu6 = new MenuEntity("짜장면", 6000, "중식", ran6);
		MenuEntity menu7 = new MenuEntity("초밥", 13000, "일식", ran7);

		menustore.create(menu1);
		menustore.create(menu2);
		menustore.create(menu3);
		menustore.create(menu4);
		menustore.create(menu5);
		menustore.create(menu6);
		menustore.create(menu7);
	}
}
