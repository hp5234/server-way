package app.product.side.chip;


import app.product.products.ChipProduct;

public class SwingChips extends Chip{
    public SwingChips() {
        super(ChipProduct.SWING_CHIPS.getId(), ChipProduct.SWING_CHIPS.getKcal(), ChipProduct.SWING_CHIPS.getName(), ChipProduct.SWING_CHIPS.getDefaultPrice());
    }
}
