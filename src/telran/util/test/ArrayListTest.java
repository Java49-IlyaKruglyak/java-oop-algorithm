package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ArrayListTest {

	@Test
	void testAdd() {
		ArrayList <Integer> numbers = new ArrayList<>();
		ArrayList <String> strings = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("ABC");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());
		
	}
	@Test
	void testAddIndex() {
		ArrayList <Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		myList.add(50);
		myList.add(0, 5);
		myList.add(2, 25);
		myList.add(7, 55);
		assertEquals(5, myList.get(0));
		assertEquals(25, myList.get(2));
		assertEquals(55, myList.get(7));
		assertEquals(8, myList.size());
		
		
	}
	@Test
	void testRemoveIndex() {
		ArrayList <Integer> myList2 = new ArrayList<>();
		myList2.add(10);
		myList2.add(20);
		myList2.add(30);
		myList2.add(40);
		myList2.add(50);
		myList2.add(60);
		myList2.add(70);
		myList2.add(80);
		assertEquals(10, myList2.remove(0));
		assertEquals(40, myList2.remove(2));
		assertEquals(80, myList2.remove(5));
		assertEquals(5, myList2.size());
	


	}
}
