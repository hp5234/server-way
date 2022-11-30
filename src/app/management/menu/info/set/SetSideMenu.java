package app.management.menu.info.set;

import java.util.Arrays;

public enum SetSideMenu {
    COOKIE(1,"[1. 쿠키선택]"),
    CHIP(2,"[2. 칩 선택]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    SetSideMenu(int menuNum, String menuName) {
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
    public static int[] getAllComboSideMenuNum() {
        return Arrays.stream(SetSideMenu.values()).mapToInt(SetSideMenu::getMenuNum).toArray();
    }
}
