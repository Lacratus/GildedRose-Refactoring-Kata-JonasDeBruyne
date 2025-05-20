package com.gildedrose.Item;

public class AgedBrie extends UpdatableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality(1);
        decreaseSellIn();
        if(item.sellIn < 0) {
            increaseQuality(1);
        }
    }
}
