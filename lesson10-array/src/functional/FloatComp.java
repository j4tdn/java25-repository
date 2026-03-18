package functional;

@FunctionalInterface
public interface FloatComp {

	/**
	 * Compare 2 parameters i1 & i2
	 * 
	 * @param i1 prefix element
	 * @param i2 suffix element
	 * @return positive if i1 > i2
	 *         zero        i1 = i2
	 *         negative    i1 < i2  
	 */
	int compare(float i1, float i2);

}
