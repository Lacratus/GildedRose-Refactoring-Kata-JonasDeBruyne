package com.gildedrose;

class GildedRose {
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

            // Backstage passes goes up in quality as sellIn approaches
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
            if (item.name.equals("Aged Brie")) {
                item.quality = Math.min(50, item.quality + 1);
                item.sellIn--;
                continue;
            }

            item.quality = Math.max(0, item.quality - (item.sellIn < 0 ? 2 : 1));
            item.sellIn--;
        }
    }
}
