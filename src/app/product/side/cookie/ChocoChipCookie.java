package app.product.side.cookie;

import app.product.products.CookieProduct;

public class ChocoChipCookie extends Cookie{
    public ChocoChipCookie() {
        super(CookieProduct.CHOCO_CHIP_COOKIE.getId(), CookieProduct.CHOCO_CHIP_COOKIE.getKcal(), CookieProduct.CHOCO_CHIP_COOKIE.getName(), CookieProduct.CHOCO_CHIP_COOKIE.getDefaultPrice());
    }
}
