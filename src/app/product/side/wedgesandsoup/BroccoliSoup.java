package app.product.side.wedgesandsoup;

import app.product.products.WedgesAndSoupProduct;

public class BroccoliSoup extends WedgesAndSoup {

    public BroccoliSoup() {
        super(WedgesAndSoupProduct.BROCCOLI_SOUP.getId(), WedgesAndSoupProduct.BROCCOLI_SOUP.getKcal(), WedgesAndSoupProduct.BROCCOLI_SOUP.getName(), WedgesAndSoupProduct.BROCCOLI_SOUP.getDefaultPrice());
    }
}
