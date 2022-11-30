package app.management.menu.info;

import java.util.Arrays;

public enum ProductCategoryMenu {
    ORDER_SANDWICH(1,"[1. 샌드위치 단품 주문하기]"),
    ORDER_SIDE(2,"[2. 사이드 단품 주문하기]"),
    ORDER_SET(3,"[3. 세트 주문하기]"),
    ORDER_COMBO(4,"[4. 콤보 선택하기]"),
    GO_TO_FIRST(0,"[0. 처음으로]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    ProductCategoryMenu(int menuNum, String menuName) {
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
    public static int[] getAllProductCategoryMenuNum() {
        return Arrays.stream(ProductCategoryMenu.values()).mapToInt(ProductCategoryMenu::getMenuNum).toArray();
    }
}
