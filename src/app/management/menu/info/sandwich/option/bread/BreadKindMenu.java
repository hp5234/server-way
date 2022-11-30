package app.management.menu.info.sandwich.option.bread;

import java.util.Arrays;

public enum BreadKindMenu {
    WHITE_BREAD(1,"[1. 화이트]"),
    WHEAT_BREAD(2,"[2. 위트]"),
    HONEY_OAT(3,"[3. 허니오트]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    BreadKindMenu(int menuNum, String menuName) {
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
    public static int[] getAllBreadKindMenuNum() {
        return Arrays.stream(BreadKindMenu.values()).mapToInt(BreadKindMenu::getMenuNum).toArray();
    }
}
