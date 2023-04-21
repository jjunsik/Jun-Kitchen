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

        for (MenuEnum category : MenuEnum.values()){
            printRevWithCategory(category, foundMenus);
        }

        int allRev = 0;
        for(MenuEntity menuEntity : foundMenus) {
            allRev += menuEntity.getMenuRevenue();
        }
        System.out.println("총매출: " + allRev + "만원");
    }

    private void printRevWithCategory(MenuEnum category, List<MenuEntity> foundMenus){
        System.out.println("----------------------- " + category.getName() + " -----------------------");

        for(MenuEntity menuEntity : foundMenus){
            if(menuEntity.getCategory().equals(category)) {
                System.out.println("메뉴 이름: " + menuEntity.getMenuName() + ", 매출액: " + menuEntity.getMenuRevenue()+ "만원");
            }
        }
        System.out.println("\n");
    }
}

