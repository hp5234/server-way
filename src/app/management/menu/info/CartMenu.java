package app.management.menu.info;

import java.util.Arrays;

public enum CartMenu {
    GO_TO_PAYMENT(1,"[1. 결제하기]"),
    VIEW_DETAIL(2, "[2. 항목 상세보기]"),
    REMOVE_FROM_CART(3,"[3. 장바구니에서 삭제하기]"),
    CLEAR_CART(4,"[4. 비우기]"),
    GO_TO_FIRST(0,"[0. 처음으로]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    CartMenu(int menuNum, String menuName) {
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
    public static int[] getAllCartMenuNum() {
        return Arrays.stream(CartMenu.values()).mapToInt(CartMenu::getMenuNum).toArray();
    }
}
