package main.java.kitchen.menu;

import main.java.kitchen.enums.MenuEnum;
import main.java.kitchen.menu.entity.MenuEntity;
import main.java.kitchen.menu.store.MenuStore;
import main.java.kitchen.menu.store.MenuStoreLifeCycle;

public class InitMenu {
	private static final MenuStore menuStore = MenuStoreLifeCycle.getUniqueInstance().requestMenuStore();

	public static void set() {
		String[] names = new String[] {
				"불고기", "파스타", "비빔밥", "삼겹살", "짜장면", "짬뽕", "초밥", "피자"
		};

		Integer[] prices = new Integer[] {
				15000, 17000, 13000, 14000, 6000, 8000, 12000, 25000
		};

		MenuEnum[] enums = new MenuEnum[]{
				MenuEnum.KOREAN,
				MenuEnum.WESTERN,
				MenuEnum.KOREAN,
				MenuEnum.KOREAN,
				MenuEnum.CHINESE,
				MenuEnum.CHINESE,
				MenuEnum.JAPANESE,
				MenuEnum.WESTERN
		};

		for (int i = 0; i < names.length; i++) {
			MenuEntity menu = new MenuEntity(names[i], prices[i], enums[i], ((int)(Math.random()*401) + 100));
			menuStore.create(menu);
		}
	}
}
