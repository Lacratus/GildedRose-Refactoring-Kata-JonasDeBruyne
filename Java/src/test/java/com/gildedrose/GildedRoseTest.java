package com.gildedrose;

import com.gildedrose.Item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void agedBrieIncreasesInQualityByOne_SellInHigherThanZeroAfterNight() {
        Item[] items = { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items[0].quality);
        assertEquals(1, items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQualityByTwo_SellInLowerThanZeroAfterNight() {
        Item[] items = { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void backstagePassIncreasesInQualityByOne_SellInHigherThanTenAfterNight() {
        Item[] items = { new Item("Backstage passes for aliens", 12, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items[0].quality);
        assertEquals(11, items[0].sellIn);
    }

    @Test
    void backstagePassIncreasesInQualityByTwo_SellInLowerThanTenAfterNight() {
        Item[] items = { new Item("Backstage passes for Taylor Swift", 9, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].quality);
        assertEquals(8, items[0].sellIn);
    }

    @Test
    void backstagePassIncreasesInQualityByThree_SellInLowerThanFiveAfterNight() {
        Item[] items = { new Item("Backstage passes for Metallica", 3, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, items[0].quality);
        assertEquals(2, items[0].sellIn);
    }

    @Test
    void backstagePassQualityBecomesZero_SellInZero_ConcertEnded() {
        Item[] items = { new Item("Backstage passes for Ragnarok", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void conjuredItemDecreasesInQualityByTwo_SellInHigherThanZeroAfterNight() {
        Item[] items = { new Item("Conjured Tea", 12, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
        assertEquals(11, items[0].sellIn);
    }

    @Test
    void conjuredItemDecreasesInQualityByFour_SellInLowerThanZeroAfterNight() {
        Item[] items = { new Item("Conjured Pie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void conjuredItemDecreasesInQualityByFour_SellInLowerThanZeroAfterNight_MinimumQualityZero() {
        Item[] items = { new Item("Conjured Milk", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void defaultItemDecreasesInQualityByOne_SellInHigherThanZeroAfterNight() {
        Item[] items = { new Item("Stone", 10, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void defaultItemDecreasesInQualityByOne_SellInLowerThanZeroAfterNight() {
        Item[] items = { new Item("A Random Item", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void sulfurasDoesNotDecreaseOrIncreaseInValue() {
        Item[] items = { new Item("Sulfuras", 1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].quality);
        assertEquals(1, items[0].sellIn);
    }


}
