package src;

public abstract class AbstractItem implements ItemInterface {
    private static final int MAX_QUALITY_ALLOWED = 50;
    private static final int MIN_QUALITY_ALLOWED = 0;

    int quality;
    int sellIn;
    public String name;


    public AbstractItem(final String name, final int sellIn, final int quality) {
        if(quality < MIN_QUALITY_ALLOWED || quality > MAX_QUALITY_ALLOWED) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public void updateSellIn() {
        --sellIn;
    }

    protected void increaseQualityIfAllowed() {
        if(quality < MAX_QUALITY_ALLOWED) {
            quality++;
        }
    }

    public boolean hasPassedSellIn() {
        return sellIn < 0;
    }

    protected void decreaseQualityIfAllowed() {
        if(quality > MIN_QUALITY_ALLOWED) {
            quality--;
        }
    }

    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


}
