package app.product.side.wedgesandsoup;

import app.product.products.WedgesAndSoupProduct;

public class WedgePotato extends WedgesAndSoup {

    public WedgePotato() {
        super(WedgesAndSoupProduct.WEDGE_POTATO.getId(), WedgesAndSoupProduct.WEDGE_POTATO.getKcal(), WedgesAndSoupProduct.WEDGE_POTATO.getName(), WedgesAndSoupProduct.WEDGE_POTATO.getDefaultPrice());
    }
}
