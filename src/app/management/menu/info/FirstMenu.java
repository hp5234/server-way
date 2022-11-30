package app.management.menu.info;

import java.util.Arrays;

public enum FirstMenu {

    CHOOSE_PRODUCT(1,"[1. 제품선택]"),
    CART(2,"[2. 장바구니]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    FirstMenu(int menuNum, String menuName) {
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
    public static int[] getAllFirstMenuNum() {
        return Arrays.stream(FirstMenu.values()).mapToInt(FirstMenu::getMenuNum).toArray();
    }
}
