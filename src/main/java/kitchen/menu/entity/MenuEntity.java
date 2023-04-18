package main.java.kitchen.menu.entity;

public class MenuEntity {
	private String menuName;
	private int menuPrice;
	private String category;
	private int menuRevenue;

	public MenuEntity(String menuName, int menuPrice, String category, int menuRevenue) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("메뉴 이름 : ").append(menuName);
		builder.append(", 메뉴 가격 : ").append(menuPrice).append("원");

		return builder.toString();
	}
}
