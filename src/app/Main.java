package app;

import app.config.AppConfigurer;
import app.management.OrderApp;

public class Main {
    public static void main(String[] args) {

        AppConfigurer appConfigurer = new AppConfigurer();

        OrderApp orderApp = new OrderApp(
                appConfigurer.getMenu(),
                appConfigurer.getMenuHandler(),
                appConfigurer.getCart(),
                appConfigurer.getProductMaker(),
                appConfigurer.getDiscountHandler(),
                appConfigurer.getPayment());

        orderApp.start();
    }
}
