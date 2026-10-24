package java25.com.dto;

import java25.com.persistence.Item;
import java25.com.persistence.ItemGroup;

public class ItemJoinItemGroup {
    private ItemGroup itemGroup;
    private Item item;

    public ItemJoinItemGroup() {
    }

    public ItemJoinItemGroup(ItemGroup itemGroup, Item item) {
        this.itemGroup = itemGroup;
        this.item = item;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemJoinItemGroup{" +
                "itemGroup=" + itemGroup +
                ", item=" + item +
                '}';
    }
}
