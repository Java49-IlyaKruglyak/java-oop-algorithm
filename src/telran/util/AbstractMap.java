package telran.util;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	protected Set<Entry<K, V>> set;
	@Override
	public V get(K key) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		
		return entry == null ? null : entry.getValue();
	}

	@Override
	public V put(K key, V value) {
		if(key == null) {
			throw new NullPointerException("Key is null");
		}
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		V res = null;
		if (entry != null) {
			res = entry.getValue();
			entry.setValue(value);
		} else {
			set.add(new Entry<>(key, value));
		}
		return res;
	}

	@Override
	public boolean containsKey(K key) {
		if(key == null) {
			throw new NullPointerException("Key is null");
		}
		
		return set.stream().anyMatch(e -> e.getKey().equals(key));
	}

	@Override
	public boolean containsValue(V value) {
		if(value == null) {
			throw new NullPointerException("Value is null");
		}
	
		return  set.stream().anyMatch(e -> e.getValue().equals(value));
	}

	@Override
	public Set<K> keySet() {
		Set<K> res = getKeySet();
		set.stream().map(e -> e.getKey()).forEach(key -> res.add(key));
		return res;
	}

	abstract protected Set<K> getKeySet();

	@Override
	public Collection<V> values() {
		List<V> res = new ArrayList<>();
		set.stream().forEach((k) -> res.add(k.getValue())); 
			
		return res;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		
		return set;
	}
	@Override
	public V remove(K key) {
		if(key == null) {
			throw new NullPointerException("Specified key is null");
		}
		V value = get(key);
		if(!set.remove(new Entry<>(key, null))) {
			value = null;
		}
		
		return value;
	}

}
