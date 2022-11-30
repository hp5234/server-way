package app.management.menu.info.sandwich.option.bread;

import java.util.Arrays;

public enum BreadLengthMenu {

    SHORT(1,"[1. 15cm]", 15),
    LONG(2,"[2. 30cm]", 30);

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final int value;

    BreadLengthMenu(int menuNum, String menuName, int value) {
        this.menuNum = menuNum;
        this.menuName = menuName;
        this.value = value;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getValue() {
        return value;
    }

    // 모든 메뉴 번호 반환
    public static int[] getAllBreadLengthMenuNum() {
        return Arrays.stream(BreadLengthMenu.values()).mapToInt(BreadLengthMenu::getMenuNum).toArray();
    }
}
