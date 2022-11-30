package app.management.menu;

import java.util.Arrays;

public enum YesOrNo {
    YES(1,"[1. 예]"),
    NO(2, "[2. 아니오]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    YesOrNo(int menuNum, String menuName) {
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
    public static int[] getAllYesOrNoNum() {
        return Arrays.stream(YesOrNo.values()).mapToInt(YesOrNo::getMenuNum).toArray();
    }
}
