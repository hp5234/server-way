package app.management.menu.info.side;

import java.util.Arrays;

public enum SideMenu {

    ORDER_COOKIE(1,"[1. 🍪 쿠키]"),
    ORDER_CHIP(2,"[2. 🥠 칩]"),
    ORDER_WEDGES_AND_SOUP(3,"[3. 🍟🍵 웨지 또는 스프]"),
    ORDER_DRINK(4,"[4. 🥤☕️ 음료]"),
    GO_TO_FIRST(0,"[0. 처음으로]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    SideMenu(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    // 모든 메뉴 번호 반환
    public static int[] getAllSideMenuNum() {
        return Arrays.stream(SideMenu.values()).mapToInt(SideMenu::getMenuNum).toArray();
    }
}

