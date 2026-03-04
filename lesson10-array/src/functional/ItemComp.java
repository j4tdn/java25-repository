package functional;

import bean.Item;

@FunctionalInterface
public interface ItemComp {

	/**
	 * Compare 2 parameters i1 & i2
	 * 
	 * @param i1 prefix element
	 * @param i2 suffix element
	 * @return positive if i1 > i2
	 *         zero        i1 = i2
	 *         negative    i1 < i2  
	 */
	int compare(Item i1, Item i2);

}