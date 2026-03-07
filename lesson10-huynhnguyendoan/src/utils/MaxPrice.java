package utils;
import bean.Item;

public class MaxPrice {
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
