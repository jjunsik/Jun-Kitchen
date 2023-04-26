package main.java.kitchen.menu.display;

import java.util.Comparator;
import java.util.List;

import main.java.kitchen.enums.MenuEnum;
import main.java.kitchen.menu.entity.MenuEntity;
import main.java.kitchen.menu.service.MenuService;
import main.java.kitchen.menu.service.MenuServiceLogicLifeCycle;
import main.java.util.ConsoleUtil;
import main.java.util.ReplyUtil;

public class MenuConsole {
	private final ConsoleUtil consoleUtil;
	private final MenuService menuService;
	private final ReplyUtil replyUtil;

	private final String enumSplit = ", ";

	public MenuConsole() {
		this.consoleUtil = ConsoleUtil.getInstance();
		this.menuService = MenuServiceLogicLifeCycle.getUniqueInstance().getMenuService();
		this.replyUtil = ReplyUtil.getInstance();
	}

	public void allMenu(){
		List<MenuEntity> foundMenus =  menuService.findAll();

		foundMenus.sort(new Comparator<MenuEntity>() {
			@Override
			public int compare(MenuEntity o1, MenuEntity o2) {
				int value = o1.getMenuPrice() - o2.getMenuPrice();

				return value == 0 ? o1.getMenuName().length() - o2.getMenuName().length() : value;
			}
		});

		if(foundMenus.isEmpty()) {
			System.out.println("등록된 메뉴가 없습니다. 메뉴를 추가해주세요!");
			return;
		}

		for (MenuEnum category : MenuEnum.values()) {
			printMenusWithCategory(category, foundMenus);
		}

	}

	private void printMenusWithCategory (MenuEnum category, List<MenuEntity> foundMenus) {
		System.out.println("----------------------- " + category.getName() + " -----------------------");

		for(MenuEntity menuEntity : foundMenus) {
			if(menuEntity.getCategory().equals(category)) {
				System.out.println(menuEntity);
			}
		}
		System.out.println("\n");
	}

	public void addMenu() {
		while(true) {
			String menuName = consoleUtil.getValueOf("메뉴 이름(" + replyUtil.getBackString() + ". 이전)");
			if(replyUtil.isBack(menuName)) {
				return;
			}

			int menuPrice = consoleUtil.getIntOf("메뉴 가격(" + replyUtil.getBackInt() + ". 이전)");
			if(replyUtil.isBack(menuPrice)) {
				return;
			} else if(menuPrice < 0){
				System.out.println("잘못된 입력입니다.");
				return;
			}

			MenuEnum[] menuEnums = MenuEnum.values();

			StringBuilder stringBuilder = new StringBuilder("카테고리(");
			for (MenuEnum menuEnum : menuEnums){
				stringBuilder.append(menuEnum.getName())
						.append(enumSplit);
			}

			String menusString = stringBuilder.substring(0, stringBuilder.length()-2);
			String category = consoleUtil.getValueOf(menusString
					+ "("
					+ replyUtil.getBackString() + ". 이전))");

			if(replyUtil.isBack(category)) {
				return;
			}

			int cnt = 0;
			for(MenuEnum menuEnum : MenuEnum.values()) {
				if (menuEnum.getName().equals(category)) {
					cnt += 1;
				}
			}

			if (cnt != 1){
				System.out.println("존재하지 않는 카테고리입니다.");
				return;
			}

			MenuEnum menuCategory = null;

			for (MenuEnum menuEnum : menuEnums) {
				if (menuEnum.getName().equals(category)) {
					menuCategory = menuEnum;
				}
			}

			int menuRev = 0;
			String confirmStr = consoleUtil.getValueOf("추가(Y: 예, N: 아니오)").toLowerCase();
			if ( replyUtil.checkIsYes(confirmStr) ) {
				MenuEntity newMenu = new MenuEntity(menuName, menuPrice, menuCategory, menuRev);
				menuService.addMenu(newMenu);
				System.out.println("메뉴가 추가되었습니다.\n" + newMenu);
			} else if ( replyUtil.checkIsNo(confirmStr) ){
				System.out.println("취소되었습니다.");
				return;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}
	}

	public void modifyMenu() {

		String menuName = consoleUtil.getValueOf("메뉴 이름(" + replyUtil.getBackString() + ". 이전)");
		if(replyUtil.isBack(menuName)) {
			return;
		}

		MenuEntity targetMenu = menuService.findByName(menuName);
		if(targetMenu == null) {
			System.out.println("존재하지 않는 메뉴입니다.");
			return;
		}

		System.out.println("수정 전 메뉴의 가격: " + targetMenu.getMenuPrice());

		int newMenu = consoleUtil.getIntOf("수정할 메뉴의 가격(" + replyUtil.getBackInt() + ". 이전)");
		if(replyUtil.isBack(newMenu)) {
			return;
		} else if(newMenu < 0){
			System.out.println("잘못된 입력입니다.");
			return;
		}

		System.out.println("수정 전 메뉴의 카테고리: " + targetMenu.getCategory().getName());

		MenuEnum[] menuEnums = MenuEnum.values();

		StringBuilder stringBuilder = new StringBuilder("수정할 메뉴의 카테고리(");
		for (MenuEnum menuEnum : menuEnums){
			stringBuilder.append(menuEnum.getName())
					.append(enumSplit);
		}

		String menusString = stringBuilder.substring(0, stringBuilder.length()-2);
		String newCategory = consoleUtil.getValueOf(menusString
				+ "("
				+ replyUtil.getBackString() + ". 이전))");

		if(replyUtil.isBack(newCategory)) {
			System.out.println("수정이 취소되었습니다.");
			return;
		}

		int cnt = 0;
		for(MenuEnum menuEnum : MenuEnum.values()) {
			if (menuEnum.getName().equals(newCategory)) {
				cnt += 1;
			}
		}

		if (cnt != 1){
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}

		MenuEnum menuCategory = null;

		for (MenuEnum menuEnum : menuEnums) {
			if (menuEnum.getName().equals(newCategory)) {
				menuCategory = menuEnum;
			}
		}

		String confirmStr= consoleUtil.getValueOf("수정(Y: 예, N: 아니오)").toLowerCase();
		if (replyUtil.checkIsYes(confirmStr)){
			targetMenu.setMenuPrice(newMenu);
			targetMenu.setCategory(menuCategory);
			menuService.modifyMenu(targetMenu);
			System.out.println("수정된 메뉴 --> " + targetMenu);
		} else if(replyUtil.checkIsNo(confirmStr)){
			System.out.println("수정이 취소되었습니다.");
		}else{
			System.out.println("잘못된 입력입니다.");
		}
	}

	public void removeMenu() {
		String menuName = consoleUtil.getValueOf("메뉴 이름(" + replyUtil.getBackString() + ". 이전)");
		if(replyUtil.isBack(menuName)) {
			return;
		}

		MenuEntity targetMenu = menuService.findByName(menuName);
		if(targetMenu == null) {
			System.out.println("존재하지 않는 메뉴입니다.");
			return;
		}

		String confirmStr = consoleUtil.getValueOf("이 매뉴를 삭제하시겠습니까?(Y: 예, N: 아니오)").toLowerCase();
		if (replyUtil.checkIsYes(confirmStr)) {
			menuService.removeMenu(menuName);
			System.out.println("메뉴가 삭제되었습니다.\n삭제된 메뉴 이름: " + menuName);
		} else if (replyUtil.checkIsNo(confirmStr)){
			System.out.println("삭제를 취소했습니다.");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}
}
