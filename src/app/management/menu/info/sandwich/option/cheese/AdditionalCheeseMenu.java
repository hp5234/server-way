package app.management.menu.info.sandwich.option.cheese;

import java.util.Arrays;

public enum AdditionalCheeseMenu {
    AMERICAN_CHEESE(1,"[1. 아메리칸]"),
    MOZZARELLA_CHEESE(2,"[2. 모차렐라]"),
    NONE_CHEESE(3,"[3. 추가안함]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    AdditionalCheeseMenu(int menuNum, String menuName) {
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
    public static int[] getAllAdditionalCheeseMenuNum() {
        return Arrays.stream(AdditionalCheeseMenu.values()).mapToInt(AdditionalCheeseMenu::getMenuNum).toArray();
    }
}


