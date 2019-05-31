package src;

public class Sulfuras implements ItemInterface {
    private final int quality;

    public Sulfuras(int quality){
        this.quality = quality;
    }


    @Override
    public void updateSellIn() {
        // nothing I guess
    }

    @Override
    public void updateQuality() {
        // lel
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public int getSellIn() {
        return 1000000;
    }
}
