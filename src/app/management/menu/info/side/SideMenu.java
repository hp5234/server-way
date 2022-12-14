package app.management.menu.info.side;

import java.util.Arrays;

public enum SideMenu {

    ORDER_COOKIE(1,"[1. πͺ μΏ ν€]"),
    ORDER_CHIP(2,"[2. π₯  μΉ©]"),
    ORDER_WEDGES_AND_SOUP(3,"[3. ππ΅ μ¨μ§ λλ μ€ν]"),
    ORDER_DRINK(4,"[4. π₯€βοΈ μλ£]"),
    GO_TO_FIRST(0,"[0. μ²μμΌλ‘]");

    private final int menuNum; // λ©λ΄ λ²νΈ
    private final String menuName;

    SideMenu(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    // λͺ¨λ  λ©λ΄ λ²νΈ λ°ν
    public static int[] getAllSideMenuNum() {
        return Arrays.stream(SideMenu.values()).mapToInt(SideMenu::getMenuNum).toArray();
    }
}

