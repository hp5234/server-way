package app.management.menu.info.sandwich.option.vegetable;

import java.util.Arrays;

public enum VegetablesIngreOptionMenu {
    LETTUCE(1,"[1. 양상추]"),
    TOMATO(2,"[2. 토마토]"),
    CUCUMBER(3, "[3. 오이]"),
    PICKLE(4,"[4. 피클]"),
    OLIVE(5,"[5. 올리브]"),
    JALAPENOS(6,"[6. 할라피뇨]"),
    ALL(0, "[0. 모두포함]"),
    COMPLETE(9,"[9. 야채 선택완료]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    VegetablesIngreOptionMenu(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    // 야채 메뉴 번호만 반환
    public static int[] getAllOnlyVegeMenuNum() {
        return Arrays.stream(VegetablesIngreOptionMenu.values()).filter(x -> x.getMenuNum() != 0 && x.getMenuNum() != 9).mapToInt(VegetablesIngreOptionMenu::getMenuNum).toArray();
    }
    // 모든 메뉴 번호 반환
    public static int[] getAllVegetablesIngreOptionMenu(){
        return Arrays.stream(VegetablesIngreOptionMenu.values()).mapToInt(VegetablesIngreOptionMenu::getMenuNum).toArray();
    }
}
