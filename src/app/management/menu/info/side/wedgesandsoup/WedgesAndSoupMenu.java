package app.management.menu.info.side.wedgesandsoup;

import app.product.products.WedgesAndSoupProduct;

import java.util.Arrays;

public enum WedgesAndSoupMenu {
    BROCCOLI_SOUP(1, "[1.🍵 브로콜리스프]", WedgesAndSoupProduct.BROCCOLI_SOUP.getDefaultPrice()),
    MUSHROOM_SOUP(2, "[2.🍵 머쉬룸스프]", WedgesAndSoupProduct.MUSHROOM_SOUP.getDefaultPrice()),
    HASHBROWN(3, "[3.🍟 해쉬브라운]", WedgesAndSoupProduct.HASHBROWN.getDefaultPrice()),
    WEDGE_POTATO(4, "[4.🍟 웨지감자]", WedgesAndSoupProduct.WEDGE_POTATO.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. 처음으로]", 0);


    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int price;

    WedgesAndSoupMenu(int menuNum, String menuName, int price) {
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
    public static int[] getAllWedgesAndSoupMenuNum() {
        return Arrays.stream(WedgesAndSoupMenu.values()).mapToInt(WedgesAndSoupMenu::getMenuNum).toArray();
    }
}
