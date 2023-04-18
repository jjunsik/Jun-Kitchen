package main.java.kitchen.menu.display;

import java.util.List;

import main.java.kitchen.menu.entity.MenuEntity;
import main.java.kitchen.menu.service.MenuService;
import main.java.kitchen.menu.service.MenuServiceLogicLifeCycle;
import main.java.util.ConsoleUtil;

public class MenuConsole {
	private ConsoleUtil consoleutil;
	private MenuService menuservice;

	public MenuConsole() {
		this.consoleutil = new ConsoleUtil();
		this.menuservice = MenuServiceLogicLifeCycle.getUniqueInstance().getMenuService();
	}

	public void allMenu() {
		List<MenuEntity> foundmenus =  menuservice.findAll();
		foundmenus.sort((m1, m2) -> ((Integer) m1.getMenuPrice()).compareTo(m2.getMenuPrice()));
		if(foundmenus.isEmpty()) {
			System.out.println("등록된 메뉴가 없습니다. 메뉴를 추가해주세요!");
			return;
		}

		System.out.println("----------------------- 한식 -----------------------");
		for(MenuEntity menuentity : foundmenus) {
			if(menuentity.getCategory().equals("한식")) {
				System.out.println(menuentity.toString());
			}
		}
		System.out.println("\n");

		System.out.println("----------------------- 양식 -----------------------");
		for(MenuEntity menuentity : foundmenus) {
			if(menuentity.getCategory().equals("양식")) {
				System.out.println(menuentity.toString());
			}
		}
		System.out.println("\n");

		System.out.println("----------------------- 중식 -----------------------");
		for(MenuEntity menuentity : foundmenus) {
			if(menuentity.getCategory().equals("중식")) {
				System.out.println(menuentity.toString());
			}
		}
		System.out.println("\n");

		System.out.println("----------------------- 일식 -----------------------");

		for(MenuEntity menuentity : foundmenus) {
			if(menuentity.getCategory().equals("일식")) {
				System.out.println(menuentity.toString());
			}
		}

		System.out.println("\n");
	}

	public void addMenu() {
		while(true) {
			String menuname = consoleutil.getValueOf("메뉴 이름(0. 이전) ");
			if(menuname.equals("0")) {
				return;
			}

			int menuprice = consoleutil.getIntOf("메뉴 가격(0. 이전) ");
			if(menuprice == 0) {
				return;
			}

			String category = consoleutil.getValueOf("카테고리(한식, 양식, 중식, 일식 중 입력)(0. 이전)");
			if(category.equals("0")) {
				return;
			}

			int menurev = 0;
			MenuEntity newmenu = new MenuEntity(menuname, menuprice, category, menurev);
			menuservice.addMenu(newmenu);
			System.out.println("메뉴가 추가되었습니다.\n" + newmenu.toString());
		}
	}

	public void modifyMenu() {

		String menuname = consoleutil.getValueOf("메뉴 이름(0. 이전)");
		if(menuname.equals("0")) {
			return;
		}

		MenuEntity targetmenu = menuservice.findByName(menuname);
		if(targetmenu == null) {
			System.out.println("존재하지 않는 메뉴입니다.");
			return;
		}

		System.out.println("수정 전 메뉴의 가격: " + targetmenu.getMenuPrice());

		Integer newmenu = consoleutil.getIntOf("수정할 메뉴의 가격(0. 이전)");
		if(newmenu == 0) {
			return;
		}
		if(newmenu != null) {
			targetmenu.setMenuPrice(newmenu);
		}

		System.out.println("수정 전 메뉴의 카테고리: " + targetmenu.getCategory());

		String newcategory = consoleutil.getValueOf("수정할 메뉴의 카테고리(한식, 양식, 중식, 일식 중 입력)(0. 이전)");
		if(newcategory.equals("0")) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}
		else if(newcategory.equals("한식") || newcategory.equals("일식") || newcategory.equals("중식") || newcategory.equals("양식")) {
			targetmenu.setCategory(newcategory);
		}
		else {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		menuservice.modifyMenu(targetmenu);

		System.out.println("수정된 메뉴 --> " + targetmenu.toString());
	}

	public void removeMenu() {
		String menuname = consoleutil.getValueOf("메뉴 이름(0. 이전)");
		if(menuname.equals("0")) {
			return;
		}

		MenuEntity targetmenu = menuservice.findByName(menuname);
		if(targetmenu == null) {
			System.out.println("존재하지 않는 메뉴입니다.");
			return;
		}

		String confirmstr = consoleutil.getValueOf("이 매뉴를 삭제하시겠습니까?(Y: 예, N: 아니오)");
		if(confirmstr.toLowerCase().equals("y") || confirmstr.equals("예")) {
			System.out.println("메뉴가 삭제되었습니다.\n삭제된 메뉴 이름: " + targetmenu.getMenuName());
			menuservice.removeMenu(targetmenu.getMenuName());
		}else if(confirmstr.toLowerCase().equals("n") || confirmstr.equals("아니오")){
			System.out.println("삭제를 취소했습니다.");
		}
	}
}
