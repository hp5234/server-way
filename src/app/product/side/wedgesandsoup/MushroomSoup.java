package app.product.side.wedgesandsoup;

import app.product.products.WedgesAndSoupProduct;

public class MushroomSoup extends WedgesAndSoup{

    public MushroomSoup() {
        super(WedgesAndSoupProduct.MUSHROOM_SOUP.getId(), WedgesAndSoupProduct.MUSHROOM_SOUP.getKcal(), WedgesAndSoupProduct.MUSHROOM_SOUP.getName(), WedgesAndSoupProduct.MUSHROOM_SOUP.getDefaultPrice());
    }
}
