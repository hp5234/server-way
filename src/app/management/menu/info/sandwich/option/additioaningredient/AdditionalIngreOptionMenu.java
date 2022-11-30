package app.management.menu.info.sandwich.option.additioaningredient;

import java.util.Arrays;

public enum AdditionalIngreOptionMenu {
    EGG_MAYO(1,"[1. 에그마요]"),
    PEPPERONI(2,"[2. 페퍼로니]"),
    BACON(3,"[3. 베이컨]"),
    AVOCADO(4, "[4. 아보카도]"),
    OMELETTE(5,"[5. 오믈렛]"),
    NONE_ADDITIONAL_INGRE(0,"[0. 추가재료 선택 안함]"),
    COMPLETE(9,"[9. 추가재료 선택완료]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;

    AdditionalIngreOptionMenu(int menuNum, String menuName) {
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
    public static int[] getAllOnlyIngreMenuNum() {
        return Arrays.stream(AdditionalIngreOptionMenu.values()).filter(x -> x.getMenuNum() != 0 && x.getMenuNum() != 9).mapToInt(AdditionalIngreOptionMenu::getMenuNum).toArray();
    }
    // 모든 메뉴 번호 반환
    public static int[] getAllAdditionalIngreMenuNum() {
        return Arrays.stream(AdditionalIngreOptionMenu.values()).mapToInt(AdditionalIngreOptionMenu::getMenuNum).toArray();
    }
}
