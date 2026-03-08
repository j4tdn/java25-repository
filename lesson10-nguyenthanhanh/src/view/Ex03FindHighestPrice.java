package view;

import bean.Item;

public class Ex03FindHighestPrice {

	public static void main(String[] args) {
		Item[] items = {
	            new Item(1, "A", 25.0, 101),
	            new Item(2, "B", 90.0, 102),
	            new Item(3, "C", 88.0, 102),
	            new Item(4, "D", 40.0, 101),
	            new Item(5, "E", 60.0, 102),
	            new Item(6, "F", 18.0, 101)
	        };
		
		findHighestPricePerStore(items);
	}
	
	private static void findHighestPricePerStore(Item[] items) {
        if (items == null || items.length == 0) return;

        Integer[] uniqueStores = new Integer[items.length];
        int storeCount = 0;

        for (Item item : items) {
            Integer currentStoreId = item.getStoreId();
            boolean isExists = false;
            
            for (int i = 0; i < storeCount; i++) {
                if (uniqueStores[i].equals(currentStoreId)) {
                    isExists = true;
                    break;
                }
            }

            if (!isExists) {
                uniqueStores[storeCount++] = currentStoreId;
            }
        }

        System.out.println("--- Kết quả mặt hàng đắt nhất theo từng cửa hàng ---");
        
        for (int i = 0; i < storeCount; i++) {
            Integer targetStoreId = uniqueStores[i];
            Item maxItem = null;

            for (Item item : items) {
                if (item.getStoreId().equals(targetStoreId)) {
                    if (maxItem == null || item.getSalesPrice() > maxItem.getSalesPrice()) {
                        maxItem = item;
                    }
                }
            }

            if (maxItem != null) {
                System.out.println("StoreId: " + targetStoreId + 
                    " | Item: " + maxItem.getName() + 
                    " | Price: " + maxItem.getSalesPrice());
            }
        }
    }
	
}
