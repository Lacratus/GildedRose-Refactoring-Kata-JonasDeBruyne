package com.gildedrose.Item;

public class ConjuredItem extends UpdatableItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality(2);
        decreaseSellIn();
        if(item.sellIn < 0) {
            decreaseQuality(2);
        }
    }
}
