package function;

import bean.Item;

@FunctionalInterface
public interface ItemComp {

	int compare(Item i1, Item i2);
	
}
