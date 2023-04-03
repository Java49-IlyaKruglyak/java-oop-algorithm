package telran.util;

public interface Collection<T>{
	boolean add(T obj);
	int size();
	T get(int index);
	boolean remove(T pattern);
	T[] toArray(T[] array);

}
