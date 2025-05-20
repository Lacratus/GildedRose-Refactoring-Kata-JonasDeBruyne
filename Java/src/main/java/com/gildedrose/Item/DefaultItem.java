package com.gildedrose.Item;

public class DefaultItem extends UpdatableItem {

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality(1);
        decreaseSellIn();
        if(item.sellIn < 0) {
            decreaseQuality(1);
        }
    }
}
