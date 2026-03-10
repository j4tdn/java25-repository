package ex03;

import java.util.Scanner;

class Item {
    int itemId;
    String name;
    double salesPrice;
    int storeId;

    public Item(int itemId, String name, double salesPrice, int storeId) {
        this.itemId = itemId;
        this.name = name;
        this.salesPrice = salesPrice;
        this.storeId = storeId;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        Item[] items = {
            new Item(1, "A", 25, 101),
            new Item(2, "B", 90, 102),
            new Item(3, "C", 88, 102),
            new Item(4, "D", 40, 101),
            new Item(5, "E", 60, 102),
            new Item(6, "F", 18, 101)
        };

        System.out.println("--- DANH SÁCH MẶT HÀNG ---");
        for (Item it : items) {
            System.out.println(it.itemId + " | " + it.name + " | Price: " + it.salesPrice + " | Store: " + it.storeId);
        }

        int[] processedStores = new int[items.length];
        int count = 0;

        System.out.println("\n--- MẶT HÀNG GIÁ CAO NHẤT MỖI CỬA HÀNG ---");

        for (int i = 0; i < items.length; i++) {
            int currentStoreId = items[i].storeId;
            
            boolean isProcessed = false;
            for (int j = 0; j < count; j++) {
                if (processedStores[j] == currentStoreId) {
                    isProcessed = true;
                    break;
                }
            }

            if (!isProcessed) {
                findMaxInStore(items, currentStoreId);
                
                processedStores[count] = currentStoreId;
                count++;
            }
        }
    }

    public static void findMaxInStore(Item[] items, int storeId) {
        Item maxItem = null;

        for (Item current : items) {
            if (current.storeId == storeId) {
                if (maxItem == null || current.salesPrice > maxItem.salesPrice) {
                    maxItem = current;
                }
            }
        }

        if (maxItem != null) {
            System.out.println("Cửa hàng " + storeId + ": " + maxItem.name + 
                               " (Giá: " + maxItem.salesPrice + ", Mã SP: " + maxItem.itemId + ")");
        }
    }
}