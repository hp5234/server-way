package app.product.side.cookie;


import app.product.products.CookieProduct;

public class RaspberryCheeseCookie extends Cookie{

    public RaspberryCheeseCookie() {
        super(CookieProduct.RASPBERRY_CHEESE_COOKIE.getId(), CookieProduct.RASPBERRY_CHEESE_COOKIE.getKcal(), CookieProduct.RASPBERRY_CHEESE_COOKIE.getName(), CookieProduct.RASPBERRY_CHEESE_COOKIE.getDefaultPrice());
    }
}
