package com.gildedrose.Item;

public class ItemFactory {

    public static UpdatableItem create(Item item) {
        if (item.name.contains("Aged Brie")) return new AgedBrie(item);
        if (item.name.contains("Backstage passes")) return new BackstagePass(item);
        if (item.name.contains("Conjured")) return new ConjuredItem(item);
        if (item.name.contains("Sulfuras")) return new Sulfuras(item);
        return new DefaultItem(item);
    }
}
