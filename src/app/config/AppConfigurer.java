package app.config;

import app.management.Cart;
import app.management.Payment;
import app.management.ProductMaker;
import app.management.discount.DiscountHandler;
import app.management.discount.DiscountRepository;
import app.management.menu.Menu;
import app.management.menu.MenuHandler;

public class AppConfigurer {

    private final Menu menu = new Menu();
    private final MenuHandler menuHandler = new MenuHandler(getMenu());
    private final Cart cart = new Cart();
    private final ProductMaker productMaker = new ProductMaker();
    private final DiscountRepository discountRepository = new DiscountRepository();
    private final DiscountHandler discountHandler = new DiscountHandler(getDiscountRepository());
    private final Payment payment = new Payment(getCart(), getDiscountHandler());

    public Menu getMenu() {
        return menu;
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }

    public Cart getCart() {
        return cart;
    }

    public ProductMaker getProductMaker() {
        return productMaker;
    }

    private DiscountRepository getDiscountRepository() {
        return discountRepository;
    }

    public DiscountHandler getDiscountHandler() {
        return discountHandler;
    }

    public Payment getPayment() {
        return payment;
    }
}
