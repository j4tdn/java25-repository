
package functional;

@FunctionalInterface
public interface StringComp {

	/**
	 * Compare 2 parameters s1 & s2
	 * 
	 * @param s1 prefix element
	 * @param s2 suffix element
	 * @return positive if s1 > s2
	 *         zero        s1 = s2
	 *         negative    s1 < s2  
	 */
	int compare(String s1, String s2);

}
