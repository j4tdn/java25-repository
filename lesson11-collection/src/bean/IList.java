package bean;

import java.util.Arrays;

import functional.Condition;

public interface IList <E> {

	boolean add(E e);
	
	void set(int i, E e);
	
	boolean remove(int i);
	
	boolean remove(E e);
	
	boolean removeIf(Condition<E> conition);
	
	int size();
	
	int capacity();
	
	default boolean isEmpty() {
		return size() == 0;
	}
	
}
