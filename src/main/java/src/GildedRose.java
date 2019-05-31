package src;

class GildedRose {
    ItemInterface[] items;

    public GildedRose(ItemInterface[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (ItemInterface item : items) {
            item.updateSellIn();
            item.updateQuality();
        }
    }

}