package function.lambda;

@FunctionalInterface
public interface IntComp {
	
	/** 
	 * @param i1 prefix element
	 * @param i2 suffix element
	 * 
	 * @return positive if i1 > i2
	 * 		   zero        i1 = i2
	 *         negative    i1 < i2
	 * */
	
	int compare(int a, int b);
}
