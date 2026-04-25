package bean;

import functional.Condition;

public interface iLisst<E> {

	boolean add(E e);
	
	void set(int i, E e);
	
	 E get(int i);
	
	boolean remove(int i);
	
	boolean remove(E e);
	
	boolean removeIf(Condition<E> condition);
	
	int size();
	
	int capacity();
	
	default boolean isEmpty() {
		return size() == 0;
	}
	
}
