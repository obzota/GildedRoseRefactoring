package src;

public class AgedBrie extends AbstractItem {

    public AgedBrie(int quality, int sellIn) {
        super("Aged Brie", quality, sellIn);
    }

    @Override
    public void updateQuality() {
        increaseQualityIfAllowed();
        if (hasPassedSellIn()) {
            increaseQualityIfAllowed();
        }
    }
}
