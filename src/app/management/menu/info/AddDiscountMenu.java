package app.management.menu.info;

import java.util.Arrays;

public enum AddDiscountMenu {

    ADD_RATE_DISCOUNT(1,"[1. 비율할인 추가하기 ]"),
    ADD_FIXED_DISCOUNT(2, "[2. 금액할인 추가하기 ]"),
    GO_BACK(0,"[0. 돌아가기]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    AddDiscountMenu(int menuNum, String menuName) {
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
    public static int[] getAllAddDiscountMenuNum() {
        return Arrays.stream(AddDiscountMenu.values()).mapToInt(AddDiscountMenu::getMenuNum).toArray();
    }
}
