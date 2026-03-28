package functional;

@FunctionalInterface
public interface Condition<T> {
	
	 boolean test(T t);
	
}
