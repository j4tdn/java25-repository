package function.lambda;

import bean.Item;

@FunctionalInterface
public interface ItemComp {
	int compare(Item it1, Item it2);
}
