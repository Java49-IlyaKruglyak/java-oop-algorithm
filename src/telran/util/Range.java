package telran.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer> {
	private int min;
	private int max;
	Collection <Integer> removed;
	public Range(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("min must be less than max");
		}
		this.min = min;
		this.max = max;
		removed = new LinkedList<>();
	}
	private class RangeIterator implements Iterator<Integer> {
		int current = min;
		boolean flNext = false;
		int prevElement = 0;
		@Override
		public boolean hasNext() {
			while(removed.contains(current) & (current < max)) {
				current++;
			}
			return current < max;
		}

		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			flNext = true;
			prevElement = current;
			return current++;
		}
		@Override
		public void remove() {
			if(!flNext) {
				throw new IllegalStateException();
			}
			removed.add(prevElement);
			flNext = false;
		}
		
	}
	@Override
	public Iterator<Integer> iterator() {
		
		return new RangeIterator();
	}
	
	public Integer[] toArray() {
		Integer [] array = new Integer[max - min - removed.size()];
		int index = 0;
		//First way
//		for(Integer num: this) {
//			array[index++] = num;
//		}
		//Second way
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			array[index++] = it.next();
		}
		
		return array;
	}
	public boolean removeIf(Predicate<Integer> predicate) {
		int oldSize = removed.size();
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			int obj = it.next();
			if(predicate.test(obj)) {
				it.remove();
			}
		}
		return oldSize < removed.size();
	}
	
	
	

}
