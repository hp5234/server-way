package app.management.menu.info.sandwich;

import app.product.products.SandwichProduct;

import java.util.Arrays;

public enum SandwichMenu {
    ROAST_CHICKEN_SANDWICH(1,"[1. 🍗 로스트 치킨 샌드위치]", SandwichProduct.ROAST_CHICKEN.getDefaultPrice()),
    EGG_MAYO_SANDWICH(2,"[2. 🥚 에그마요 샌드위치]", SandwichProduct.EGG_MAYO.getDefaultPrice()),
    ITALIAN_BMT_SANDWICH(3,"[3. 🥓 이탈리안 BMT 샌드위치]", SandwichProduct.ITALIAN_BMT.getDefaultPrice()),
    VEGETARIAN_SANDWICH(4,"[4. 🥬 베지테리안 전용 샌드위치]", SandwichProduct.VEGETARIAN.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. 처음으로]", 0);

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int price;

    SandwichMenu(int menuNum, String menuName, int price) {
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
    public static int[] getAllSandwichMenuNum() {
        return Arrays.stream(SandwichMenu.values()).mapToInt(SandwichMenu::getMenuNum).toArray();
    }
}
