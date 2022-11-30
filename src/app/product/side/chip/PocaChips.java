package app.product.side.chip;

import app.product.products.ChipProduct;

public class PocaChips extends Chip{
    public PocaChips() {
        super(ChipProduct.POCA_CHIPS.getId(), ChipProduct.POCA_CHIPS.getKcal(), ChipProduct.POCA_CHIPS.getName(), ChipProduct.POCA_CHIPS.getDefaultPrice());
    }
}
