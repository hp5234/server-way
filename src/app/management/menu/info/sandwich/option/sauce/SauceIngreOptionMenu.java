package app.management.menu.info.sandwich.option.sauce;

import java.util.Arrays;

public enum SauceIngreOptionMenu {
    MUSTARD(1,"[1. 머스타드]"),
    SWEET_ONION(2,"[2. 스위트어니언]"),
    SMOKED_BARBECUE(3,"[3. 스모크 바베큐]"),
    RANCH(4, "[4. 렌치]"),
    OLIVE_OIL(5,"[5. 올리브오일]"),
    NONE_SAUCE(0,"[0. 소스 선택 안함]"),
    COMPLETE(9,"[9. 소스 선택완료]");

    private final int menuNum; // 메뉴 번호
    private final String menuName;
    public static final int MAX_USABLE_COUNT = 3;

    SauceIngreOptionMenu(int menuNum, String menuName) {
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
    public static int[] getAllSauceIngreOptionMenuNum() {
        return Arrays.stream(SauceIngreOptionMenu.values()).mapToInt(SauceIngreOptionMenu::getMenuNum).toArray();
    }
}
