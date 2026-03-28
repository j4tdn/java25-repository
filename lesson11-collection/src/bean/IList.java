package bean;

import functional.Condition;

public interface IList<E> {
	
	boolean add(E e);
	
	E get(int i);
	
	void set(int i, E e);
	
	boolean remove(int i);
	
	boolean remove(E e);
	
	boolean removeIf(Condition<E> condition);
	
	int size();
	
	int capacity();
	
	default boolean isEmpty() {
		return size() == 0;
	}
	
}