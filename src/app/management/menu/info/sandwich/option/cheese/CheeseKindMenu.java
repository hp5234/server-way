package app.management.menu.info.sandwich.option.cheese;

import java.util.Arrays;

public enum CheeseKindMenu {
    AMERICAN_CHEESE(1,"[1. 아메리칸]"),
    MOZZARELLA_CHEESE(2,"[2. 모차렐라]"),
    NONE_CHEESE(3,"[3. 치즈 제외]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    CheeseKindMenu(int menuNum, String menuName) {
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
    public static int[] getAllCheeseKindMenuNum() {
        return Arrays.stream(CheeseKindMenu.values()).mapToInt(CheeseKindMenu::getMenuNum).toArray();
    }
}
