package src;

public class BackstagePass extends AbstractItem {


    public BackstagePass(int quality, int sellIn){
        super("Backstage passes to a TAFKAL80ETC concert", quality, sellIn);
    }

    @Override
    public void updateQuality() {
        if(hasPassedSellIn()){
            quality = 0;
            return;
        }

        increaseQualityIfAllowed();

        if(sellIn<10){
            increaseQualityIfAllowed();
        }
        if(sellIn<6){
            increaseQualityIfAllowed();
        }
    }
}
