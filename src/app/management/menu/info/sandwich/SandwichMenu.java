package app.management.menu.info.sandwich;

import app.product.products.SandwichProduct;

import java.util.Arrays;

public enum SandwichMenu {
    ROAST_CHICKEN_SANDWICH(1,"[1. π λ‘μ€νΈ μΉν¨ μλμμΉ]", SandwichProduct.ROAST_CHICKEN.getDefaultPrice()),
    EGG_MAYO_SANDWICH(2,"[2. π₯ μκ·Έλ§μ μλμμΉ]", SandwichProduct.EGG_MAYO.getDefaultPrice()),
    ITALIAN_BMT_SANDWICH(3,"[3. π₯ μ΄νλ¦¬μ BMT μλμμΉ]", SandwichProduct.ITALIAN_BMT.getDefaultPrice()),
    VEGETARIAN_SANDWICH(4,"[4. π₯¬ λ² μ§νλ¦¬μ μ μ© μλμμΉ]", SandwichProduct.VEGETARIAN.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. μ²μμΌλ‘]", 0);

    private final int menuNum; // λ©λ΄ λ²νΈ
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

    // λͺ¨λ  λ©λ΄ λ²νΈ λ°ν
    public static int[] getAllSandwichMenuNum() {
        return Arrays.stream(SandwichMenu.values()).mapToInt(SandwichMenu::getMenuNum).toArray();
    }
}
