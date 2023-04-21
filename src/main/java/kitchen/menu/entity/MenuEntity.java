package main.java.kitchen.menu.entity;

import main.java.kitchen.enums.MenuEnum;

public class MenuEntity {
	private String menuName;
	private int menuPrice;
	private MenuEnum category;
	private int menuRevenue;

	public MenuEntity(String menuName, int menuPrice, MenuEnum category, int menuRevenue) {
		setMenuName(menuName);
		setMenuPrice(menuPrice);
		setCategory(category);
		setMenuRevenue(menuRevenue);
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public MenuEnum getCategory() {
		return category;
	}

	public void setCategory(MenuEnum category) {
		this.category = category;
	}

	public int getMenuRevenue() {
		return menuRevenue;
	}

	public void setMenuRevenue(int menuRevenue) {
		this.menuRevenue = menuRevenue;
	}

	@Override
	public String toString() {
		return "메뉴 이름 : " + menuName +
				", 메뉴 가격 : " + menuPrice + "원";
	}
}
