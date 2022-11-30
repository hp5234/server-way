package app.management.menu.info.side.cookie;

import app.product.products.CookieProduct;

import java.util.Arrays;

public enum CookieMenu {

    CHOCO_CHIP_COOKIE(1,"[1. 🍪 초코칩 쿠키]", CookieProduct.CHOCO_CHIP_COOKIE.getDefaultPrice()),
    DOUBLE_CHOCO_CHIP_COOKIE(2,"[2. 🍪 더블 초코칩 쿠키]", CookieProduct.DOUBLE_CHOCO_CHIP_COOKIE.getDefaultPrice()),
    RASPBERRY_CHEESE_COOKIE(3,"[3. 🍪 라즈베리 치즈 쿠키]", CookieProduct.RASPBERRY_CHEESE_COOKIE.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. 처음으로]", 0);

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int price;

    CookieMenu(int menuNum, String menuName, int price) {
        this.menuNum = menuNum;
        this.menuName = menuName;
        this.price = price;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    // 모든 메뉴 번호 반환
    public static int[] getAllCookieMenuNum() {
        return Arrays.stream(CookieMenu.values()).mapToInt(CookieMenu::getMenuNum).toArray();
    }
}
