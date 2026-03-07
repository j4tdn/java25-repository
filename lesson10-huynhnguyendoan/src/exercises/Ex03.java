package exercises;

import bean.Item;

public class Ex03 {

    public static void main(String[] args) {

        Item[] items = {
            new Item(1,"A",25,101),
            new Item(2,"B",90,102),
            new Item(3,"C",88,102),
            new Item(4,"D",40,101),
            new Item(5,"E",60,102),
            new Item(6,"F",18,101)
        };

        findMaxPriceByStore(items);
    }

    public static void findMaxPriceByStore(Item[] items) {

        for (int i = 0; i < items.length; i++) {

            int store = items[i].getStoreId();
            boolean checked = false;

            for (int j = 0; j < i; j++) {
                if (items[j].getStoreId() == store) {
                    checked = true;
                    break;
                }
            }

            if (!checked) {

                Item maxItem = items[i];

                for (int k = i + 1; k < items.length; k++) {
                    if (items[k].getStoreId() == store &&
                        items[k].getSalesPrice() > maxItem.getSalesPrice()) {

                        maxItem = items[k];
                    }
                }

                System.out.println(
                    "Store " + store +
                    " -> Item: " + maxItem.getName() +
                    " Price: " + maxItem.getSalesPrice()
                );
            }
        }
    }
}