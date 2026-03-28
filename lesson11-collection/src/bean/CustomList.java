package bean;

import java.lang.reflect.Array;
import java.util.Arrays;

import functional.Condition;

public class CustomList<E> implements IList<E> {

	private E[] elementData;
	
	private int size;
	
	private final int DEFAULT_CAPACITY = 12;
	
	// Cannot create a new instance for generic type
	
	@SuppressWarnings("unchecked")
	public CustomList() {
		this.elementData =(E[]) Array.newInstance(Object.class, DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CustomList(int capacity) {
		this.elementData =(E[]) Array.newInstance(Object.class, capacity);
	}
	
	 @Override
	public boolean add(E e) {
		 if(size == elementData.length) {
			 elementData = grow();
		 }
		 elementData[size++] = e;
		return true;
	}
	 
	 @Override
	public boolean remove(E e) {
		return false;
	}
	
	 @Override
	public boolean removeIf(Condition<E> conition) {
		return false;
	}
	 
	 @Override
	public int size() {
		return size;
	}
	 
	 @Override
	public boolean remove(int i) {
		return false;
	}
	 
	 @Override
	public int capacity() {
		return elementData.length;
	}
	 
	 @Override
	public void set(int i, E e) {
		elementData[i] = e;
	}
	 
	public E get(int i) {
		return elementData[i];
	}
	 
	 private E[] grow() {
		return Arrays.copyOf(elementData, elementData.length);
	}
}
