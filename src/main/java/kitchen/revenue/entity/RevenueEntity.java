package main.java.kitchen.revenue.entity;

import java.util.Comparator;
import java.util.List;

import main.java.kitchen.enums.MenuEnum;
import main.java.kitchen.menu.entity.MenuEntity;
import main.java.kitchen.menu.service.MenuService;
import main.java.kitchen.menu.service.MenuServiceLogicLifeCycle;

public class RevenueEntity {
    private final MenuService menuService;

    public RevenueEntity() {
        this.menuService = MenuServiceLogicLifeCycle.getUniqueInstance().getMenuService();
    }

    public void allMenuRev() {
        List<MenuEntity> foundMenus =  menuService.findAll();
        foundMenus.sort(new Comparator<MenuEntity>() {
            @Override
            public int compare(MenuEntity o1, MenuEntity o2) {
                return o1.getMenuRevenue() - o2.getMenuRevenue();
            }
        });

        System.out.println("----------------------- 한식 -----------------------");
        for(MenuEntity menuentity : foundmenus) {
            if(menuentity.getCategory().equals("한식")) {
                System.out.println("메뉴 이름: " + menuentity.getMenuName() + ", 매출액: " + menuentity.getMenuRevenue() + "만원");
            }
        }
        System.out.println("\n");

    private void printRevWithCategory(MenuEnum category, List<MenuEntity> foundMenus){
        System.out.println("----------------------- " + category.getName() + " -----------------------");

        for(MenuEntity menuEntity : foundMenus){
            if(menuEntity.getCategory().equals(category)) {
                System.out.println("메뉴 이름: " + menuEntity.getMenuName() + ", 매출액: " + menuEntity.getMenuRevenue()+ "만원");
            }
        }
        System.out.println("\n");

        System.out.println("----------------------- 중식 -----------------------");
        for(MenuEntity menuentity : foundmenus) {
            if(menuentity.getCategory().equals("중식")) {
                System.out.println("메뉴 이름: " + menuentity.getMenuName() + ", 매출액: " + menuentity.getMenuRevenue() + "만원");
            }
        }
        System.out.println("\n");

        System.out.println("----------------------- 일식 -----------------------");

        for(MenuEntity menuentity : foundmenus) {
            if(menuentity.getCategory().equals("일식")) {
                System.out.println("메뉴 이름: " + menuentity.getMenuName() + ", 매출액: " + menuentity.getMenuRevenue() + "만원");
            }
        }
        System.out.println("\n");

        int allrev = 0;
        for(MenuEntity menuentity : foundmenus) {
            allrev += menuentity.getMenuRevenue();
        }
        System.out.println("총매출: " + allrev + "만원");
    }


}

