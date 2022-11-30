package app.management.menu.info;

import java.util.Arrays;

public enum DiscountMenu {

    ADD_DISCOUNT(1,"[1. 할인 추가하기 ]"),
    REMOVE_DISCOUNT(2, "[2. 할인 삭제하기 ]"),
    CLEAR_DISCOUNT(3, "[3. 할인 전체 삭제하기 ]"),
    GO_BACK(0,"[0. 돌아가기]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    DiscountMenu(int menuNum, String menuName) {
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
    public static int[] getAllDiscountMenuNum() {
        return Arrays.stream(DiscountMenu.values()).mapToInt(DiscountMenu::getMenuNum).toArray();
    }
}
