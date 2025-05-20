package com.gildedrose;

import com.gildedrose.Item.Item;
import com.gildedrose.Item.ItemFactory;
import com.gildedrose.Item.UpdatableItem;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatable = ItemFactory.create(item);
            updatable.update();
        }
    }
}
