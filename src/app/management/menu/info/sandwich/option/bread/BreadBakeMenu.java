package app.management.menu.info.sandwich.option.bread;

import java.util.Arrays;

public enum BreadBakeMenu {
    BAKE(1,"[1. 굽기]", true),
    NONE_BAKE(2,"[2. 굽기선택안함]", false);

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    private final boolean value; // 굽기 여부 boolean 값

    BreadBakeMenu(int menuNum, String menuName, boolean value) {
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

    public boolean getValue() {
        return value;
    }

    // 모든 메뉴 번호 반환
    public static int[] getAllBreadBakeMenuNum() {
        return Arrays.stream(BreadBakeMenu.values()).mapToInt(BreadBakeMenu::getMenuNum).toArray();
    }
}
