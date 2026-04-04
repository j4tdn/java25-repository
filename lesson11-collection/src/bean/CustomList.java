package bean;

import java.lang.reflect.Array;
import java.util.Arrays;

import functional.Condition;

public class CustomList<E> implements IList<E> {
	private E[] elementData;
	private int size;
	private final int DEFAULT_CAPACITY = 5;
	
	// cannot create a new instance for generic type;
	public CustomList() {
		this.elementData = createGenericArray(DEFAULT_CAPACITY);
	}
	
	
	public CustomList(int capacity) {
		this.elementData = createGenericArray(capacity);
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
	public void set(int i, E e) {
		elementData[i] = e;
	}

	@Override
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeIf(Condition<E> condition) {
		// TODO Auto-generated method stub
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


	@Override
	public E get(int i) {
		return elementData[i];
	}
	
}