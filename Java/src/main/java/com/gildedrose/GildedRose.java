package com.gildedrose;

import com.gildedrose.Item.Item;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes";
    private static final String SULFURAS = "Sulfuras";
    private static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            // Minimum quality is 0 and Maximum quality is 50
            if (item.quality < 0 || item.quality > 50) {
                continue;
            }

            if (item.name.contains(SULFURAS)) {
                continue;
            }

            // Backstage passes goes up in quality as sellIn approaches
            if (item.name.contains(BACKSTAGE_PASSES)) {
                if (item.sellIn <= 0) {
                    item.quality = 0;
                } else if (item.sellIn < 6) {
                    item.quality = Math.min(50, item.quality + 3);
                } else if (item.sellIn < 11) {
                    item.quality = Math.min(50, item.quality + 2);
                } else {
                    item.quality = Math.min(50, item.quality + 1);
                }
                item.sellIn--;
                continue;
            }

            // Brie goes up as it ages
            if (item.name.contains(AGED_BRIE)) {
                item.quality = Math.min(50, item.quality + 1);
                item.sellIn--;
                continue;
            }

            // Conjured items spoil twice as fast as normal items
            if (item.name.contains(CONJURED)) {
                item.quality = Math.max(0, item.quality - (item.sellIn < 0 ? 4 : 2));
                item.sellIn--;
                continue;
            }

            item.quality = Math.max(0, item.quality - (item.sellIn < 0 ? 2 : 1));
            item.sellIn--;
        }
    }
}
