package com.gildedrose.Item;

public class BackstagePass extends UpdatableItem {

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    public void update() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 6) {
            increaseQuality(3);
        } else if (item.sellIn < 11) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }
}
