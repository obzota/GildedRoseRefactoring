package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    @Test
    public void updateQualityForExpiredItemQualityShouldDegradeTwiceAsFast() {

        // Given
        final int initialQuality = 10;
        final Item expiredItem = new Item("Strawberry", 0, initialQuality);
        final Item regularItem = new Item("Strawberry", 5, initialQuality);
        final GildedRose rose = new GildedRose(new Item[] {expiredItem, regularItem});

        // When
        rose.updateQuality();

        // Then
        final int decreaseForExpired = initialQuality - expiredItem.getQuality();
        final int decreaseForRegular = initialQuality - regularItem.getQuality();
        assertEquals(2 * decreaseForRegular, decreaseForExpired);
    }

    @Test
    public void qualityDecreasesAtUpdate() {

        final int initialQuality = 10;
        // At the end of each day our system lowers both values for every item
        final Item item1 = new Item("Strawberry", 5, initialQuality);
        final Item item2 = new Item("Strawberry", -1, initialQuality);
        final GildedRose rose = new GildedRose(new Item[] {item1, item2});

        rose.updateQuality();

        assertTrue(item1.getQuality() < initialQuality);
        assertTrue(item2.getQuality() < initialQuality);


    }

    @Test
    public void sellInDecreasesAtUpdate() {

        final int initialSellIn = 5;
        // At the end of each day our system lowers both values for every item
        final Item item1 = new Item("Strawberry", initialSellIn, 10);
        final Item item2 = new Item("Strawberry", initialSellIn, 10);
        final GildedRose rose = new GildedRose(new Item[] {item1, item2});

        rose.updateQuality();

        assertTrue(item1.getSellIn() < initialSellIn);
        assertTrue(item2.getSellIn() < initialSellIn);
    }



    @Test
    public void minimumQualityIsZero() {
        // Given
        final int minQualityAllowed = 0;
        final Item zeroQualityItem = new Item("Lime", 10, minQualityAllowed);
        final GildedRose rose = new GildedRose(new Item[]{zeroQualityItem});

        // When
        rose.updateQuality();

        // Then
        assertEquals(minQualityAllowed, zeroQualityItem.getQuality());

    }

    @Test
    public void agedBrieQualityIncreases() {
        final int initialQuality = 15;
        final ItemInterface agedBrie = new AgedBrie(10, initialQuality);
        final GildedRose rose = new GildedRose(new ItemInterface[]{agedBrie});

        rose.updateQuality();

        assertTrue(agedBrie.getQuality() > initialQuality);
    }

    @Test
    public void increasingItemStaysAtMaxQuality() {
        final int maxQuality = 50;
        final ItemInterface agedBrie = new AgedBrie(10, maxQuality);
        final GildedRose rose = new GildedRose(new ItemInterface[]{agedBrie});

        rose.updateQuality();

        assertEquals(maxQuality, agedBrie.getQuality());
    }

    @Test
    public void legendaryItemsNeverDecreaseInQuality() {
        final int constantQuality = 12;
        final ItemInterface legendaryItem = new Sulfuras(constantQuality);
        final GildedRose rose = new GildedRose(new ItemInterface[]{legendaryItem});

        rose.updateQuality();

        assertEquals(constantQuality, legendaryItem.getQuality());
    }

    @Test
    public void legendaryItemsNeverDecreaseInSellIn() {
        final ItemInterface legendaryItem = new Sulfuras(100);
        final int constantSellIn = legendaryItem.getSellIn();
        final GildedRose rose = new GildedRose(new ItemInterface[]{legendaryItem});

        rose.updateQuality();

        assertEquals(constantSellIn, legendaryItem.getSellIn());
    }
    // “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality


    @Test
    public void backstagePassesQualityGoesToZeroAfterTheConcert() {
        final int qualityAfterConcert = 0;
        final ItemInterface backstagePasses = new BackstagePass(0, 20);
        final GildedRose rose = new GildedRose(new ItemInterface[]{backstagePasses});

        rose.updateQuality();

        assertEquals(qualityAfterConcert, backstagePasses.getQuality());
    }


    @Test
    public void backstagePassesQualityIncreaseTwice10DaysBeforeTheConcert() {
        final int qualityAfterUpdate = 12;
        final ItemInterface backstagePasses = new BackstagePass(10, 10);
        final GildedRose rose = new GildedRose(new ItemInterface[]{backstagePasses});

        rose.updateQuality();

        assertEquals(qualityAfterUpdate, backstagePasses.getQuality());
    }

    @Test
    public void backstagePassesQualityIncreaseThrice5DaysBeforeTheConcert() {
        final int qualityAfterUpdate = 13;
        final ItemInterface backstagePasses = new BackstagePass( 5, 10);
        final GildedRose rose = new GildedRose(new ItemInterface[]{backstagePasses});

        rose.updateQuality();

        assertEquals(qualityAfterUpdate, backstagePasses.getQuality());
    }


}
