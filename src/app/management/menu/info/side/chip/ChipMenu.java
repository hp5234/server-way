package app.management.menu.info.side.chip;

import app.product.products.ChipProduct;

import java.util.Arrays;

public enum ChipMenu {
    POCA_CHIPS(1,"[1. 🥠 포카칩]", ChipProduct.POCA_CHIPS.getDefaultPrice()),
    POTATO_CHIPS(2,"[2. 🥠 포테이토칩]", ChipProduct.POTATO_CHIPS.getDefaultPrice()),
    SWING_CHIPS(3,"[3. 🥠 스윙칩]", ChipProduct.SWING_CHIPS.getDefaultPrice()),
    GO_TO_FIRST(0,"[0. 처음으로]", 0);

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int price;

    ChipMenu(int menuNum, String menuName, int price) {
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
    public static int[] getAllChipMenuNum() {
        return Arrays.stream(ChipMenu.values()).mapToInt(ChipMenu::getMenuNum).toArray();
    }
}
