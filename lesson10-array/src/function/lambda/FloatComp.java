package function.lambda;

@FunctionalInterface
public interface FloatComp {
	
	/** 
	 * @param i1 prefix element
	 * @param i2 suffix element
	 * 
	 * @return positive if i1 > i2
	 * 		   zero        i1 = i2
	 *         negative    i1 < i2
	 * */
	
	int compare(float a, float b);
}
