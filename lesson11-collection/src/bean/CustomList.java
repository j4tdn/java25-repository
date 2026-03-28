package bean;

import java.lang.reflect.Array;
import java.util.Arrays;

import functional.Condition;

public class CustomList<E> implements IList<E> {

	private E[] elementData;
	private int size;
	private final int DEFAULT_CAPACITY = 5;
	
	// Cannot create a new instance for generic type
	
	public CustomList() {
		this.elementData = createGenericArray(DEFAULT_CAPACITY);
	}
	
	public CustomList(int capacity) {
		this.elementData = createGenericArray(capacity);
	}
	
	@Override
	public boolean add(E e) {
		if (size == elementData.length) {
			elementData = grow();
		}
		elementData[size++] = e;
		return true;
	}
	
	@Override
	public E get(int i) {
		return elementData[i];
	}

	@Override
	public void set(int i, E e) {
		elementData[i] = e;
	}

	// System.array...
	@Override
	public boolean remove(int i) {
		return false;
	}

	@Override
	public boolean remove(E e) {
		return false;
	}

	@Override
	public boolean removeIf(Condition<E> condition) {
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return elementData.length;
	}
	
	private E[] grow() {
		return Arrays.copyOf(elementData, elementData.length * 2);
	}
	
	@SuppressWarnings("unchecked")
	private E[] createGenericArray(int capacity) {
		return (E[])Array.newInstance(Object.class, capacity);
	}

}
