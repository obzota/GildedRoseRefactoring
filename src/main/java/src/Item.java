package src;

public class Item extends AbstractItem {

    public Item(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseQualityIfAllowed();
        if(hasPassedSellIn()) {
            decreaseQualityIfAllowed();
        }
    }
}
