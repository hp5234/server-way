package app.management.menu.info.side.drink;

import app.product.products.DrinkProduct;

import java.util.Arrays;

public enum DrinkMenu {

    COKE(1,"[1.🥤 콜라]", DrinkProduct.COKE.getDefaultPrice()),
    COKE_ZERO(2,"[2.🥤 제로콜라]", DrinkProduct.COKE_ZERO.getDefaultPrice()),
    AMERICANO(3,"[3.☕️ 아메리카노]", DrinkProduct.AMERICANO.getDefaultPrice()),
    SPRITE(4,"[4.🥤 스프라이트]", DrinkProduct.SPRITE.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. 처음으로]", 0);

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int price;

    DrinkMenu(int menuNum, String menuName, int price) {
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
    public static int[] getAllDrinkMenuNum() {
        return Arrays.stream(DrinkMenu.values()).mapToInt(DrinkMenu::getMenuNum).toArray();
    }
}
