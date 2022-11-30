package app.product.side.chip;

import app.product.products.ChipProduct;

public class PotatoChips extends Chip{

    public PotatoChips() {
        super(ChipProduct.POTATO_CHIPS.getId(), ChipProduct.POTATO_CHIPS.getKcal(), ChipProduct.POTATO_CHIPS.getName(), ChipProduct.POTATO_CHIPS.getDefaultPrice());
    }
}
