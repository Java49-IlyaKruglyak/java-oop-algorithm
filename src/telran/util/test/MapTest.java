package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.Collection;
import telran.util.Map;
import telran.util.Set;
import telran.util.Map.Entry;

import org.junit.jupiter.api.Test;

abstract class MapTest {
String[] keys = {"lmn", "abc", "ab", "a"};
Integer[] values = {3, 2, 2, 1};
protected Map<String, Integer> map;
    @BeforeEach
    void setUp() {
    	for(int i = 0; i < keys.length; i++) {
    		map.put(keys[i], values[i]);
    	}
    }
	@Test
	void getTest() {
		for(int i = 0; i < keys.length; i++) {
			assertEquals(values[i], map.get(keys[i]));
		}
	}
	@Test
	void containsKeyTest() {
		//TODO
		for( String key : keys) {
			assertTrue(map.containsKey(key));
			assertFalse(map.containsKey(key+"X"));
		}
		assertThrowsExactly(NullPointerException.class, () -> map.containsKey(null));
	}
	@Test
	void containsValueTest() {
		//TODO
		for( Integer value : values) {
			assertTrue(map.containsValue(value));
			assertFalse(map.containsValue(value+1000000));
		}
		assertThrowsExactly(NullPointerException.class, () -> map.containsValue(null));
	}
	@Test
	void valuesTest() {
		//TODO
		Collection<Integer> col = map.values();
		for( Integer value : values) {
			assertTrue(col.contains(value));
		}
		for( Integer value : values) {
			assertFalse(col.contains(value+1000));
		}
		assertEquals(values.length, col.size());
	}
	@Test
	void removeTest() {
		//TODO
		for( String key : keys) {
			assertNotNull(map.remove(key));
			assertNull(map.remove(key));			
		}
		assertEquals(0, map.entrySet().size());
		assertThrowsExactly(NullPointerException.class, () -> map.containsKey(null));
	}
	@Test
	void putTest() {
		int sizePrev = map.entrySet().size();
		Integer result = map.put(keys[0], values[0]+1000);
		assertEquals(sizePrev, map.entrySet().size());
		assertEquals(values[0]+1000, map.get(keys[0]));
		assertEquals(values[0], result);
		assertNull(map.put("xxx", 1000));
		assertEquals(sizePrev+1, map.entrySet().size());
		assertEquals(1000, map.get("xxx"));
		assertThrowsExactly(NullPointerException.class, () -> map.put(null, 10));
		map.put("kuku", null);
	}
	@Test
	void getOrDefaultTest() {
		Integer result = map.getOrDefault(keys[2], 73);
		assertEquals(values[2], result);
		result = map.getOrDefault("xxx", 73);
		assertEquals(73, result);
	}
	@Test
	void putIfAbsentTest() {
		int sizePrev = map.entrySet().size();
		Integer result = map.putIfAbsent(keys[3], 37);
		assertEquals(values[3], map.get(keys[3]));
		assertEquals(sizePrev, map.entrySet().size());
		result = map.putIfAbsent("xxx", 37);
		assertEquals(37, map.get("xxx"));
		assertEquals(sizePrev+1, map.entrySet().size());
	}
	@Test
	void keySetTest() {
		Set<String> resultKeys = map.keySet();
		for(String key: keys) {
			assertTrue(resultKeys.contains(key));
		}
		assertEquals(keys.length, resultKeys.size());
	}
	@Test
	void entrySetTest() {
		Set<Entry<String, Integer>> entries = map.entrySet();
		assertEquals(entries.size(), map.entrySet().size());
		for(String key: keys) {
			Entry<String, Integer> entry = new Entry<>(key, null);
			assertEquals(map.get(key), entries.get(entry).getValue());
		}
	}
}
	