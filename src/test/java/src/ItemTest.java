package src;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void toString1() {
        Item item = new Item("ItemName", 5, 10);

        Assert.assertEquals("ItemName, 5, 10", item.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void highQualityItem() {
        //Give
        int moreThanAllowedQuality = 51;
        //When
        Item highQualityItem = new Item("Lime", 10, moreThanAllowedQuality);
        //Then
        //exception

    }

    @Test(expected = IllegalArgumentException.class)
    public void minimumQualityItem() {
        //Give
        int lowerThanAllowedQuality = -1;
        //When
        Item highQualityItem = new Item("Lime", 10, lowerThanAllowedQuality);
        //Then
        //exception
    }

}