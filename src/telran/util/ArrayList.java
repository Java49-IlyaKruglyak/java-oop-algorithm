package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean add(T obj) {
		if (size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);

	}

	@Override
	public void add(int index, T obj) {
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		T res = array[index];

		System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;
		return res;
	}

	@Override
	public T get(int index) {
		T res = array[index];
		return res;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean remove(T pattern) {
		int index = indexOf(pattern);
		if (index != -1) {
			remove(index);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(T[] srcArray) {
		T[] destArray = srcArray;
		if (destArray.length < size) {
			destArray = (T[]) Arrays.copyOf(this.array, this.size, srcArray.getClass());
		} else {
			System.arraycopy(array, 0, destArray, 0, size);
			if (destArray.length > size) {
				destArray[size] = null;
			}

		}
		return destArray;
	}

	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}

	private boolean isEqual(T object, T pattern) {

		return pattern == null ? object == pattern : pattern.equals(object);
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		for (int i = size - 1; i > 0; i--) {
			if (isEqual(array[i], pattern)) {
				res = i;
				break;
			}
		}
		return res;
	}

}
