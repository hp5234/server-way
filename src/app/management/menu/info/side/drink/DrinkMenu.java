package app.management.menu.info.side.drink;

import app.product.products.DrinkProduct;

import java.util.Arrays;

public enum DrinkMenu {

    COKE(1,"[1.๐ฅค ์ฝ๋ผ]", DrinkProduct.COKE.getDefaultPrice()),
    COKE_ZERO(2,"[2.๐ฅค ์ ๋ก์ฝ๋ผ]", DrinkProduct.COKE_ZERO.getDefaultPrice()),
    AMERICANO(3,"[3.โ๏ธ ์๋ฉ๋ฆฌ์นด๋ธ]", DrinkProduct.AMERICANO.getDefaultPrice()),
    SPRITE(4,"[4.๐ฅค ์คํ๋ผ์ดํธ]", DrinkProduct.SPRITE.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. ์ฒ์์ผ๋ก]", 0);

    private final int menuNum; // ๋ฉ๋ด ๋ฒํธ
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

    // ๋ชจ๋  ๋ฉ๋ด ๋ฒํธ ๋ฐํ
    public static int[] getAllDrinkMenuNum() {
        return Arrays.stream(DrinkMenu.values()).mapToInt(DrinkMenu::getMenuNum).toArray();
    }
}
