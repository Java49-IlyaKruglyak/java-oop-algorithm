package telran.algorithm.test;
import telran.algorithm.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InitialAlgorithmTest {

//	@Test
//	void testSortShortPositive() {
//		short [] array = {0, 5, 2, 1, 4, 5, 8, 7};
//		short [] expected = {0, 1, 2, 4, 5, 5, 7, 8};
//		assertArrayEquals(expected, InitialAlgorithms.sortShortPositive(array));
//	}

	@Test
	void testIsSum2() {
		short [] array = {0, 5, 2, 1, 4, 5, 8, 7};
		assertTrue(InitialAlgorithms.isSum2(array, (short)7));
		assertTrue(InitialAlgorithms.isSum2(array, (short)8));
		assertTrue(InitialAlgorithms.isSum2(array, (short)12));
		assertFalse(InitialAlgorithms.isSum2(array, (short)16));
		assertFalse(InitialAlgorithms.isSum2(array, (short)-1));
	}

	@Test
	void testGetMaxPositiveWithNegativeReflect() {
		short [] array = {0, 5, 2, 1, 4, 5, 8, 7, -5, -2, -7, -8, -10};
		assertEquals(8, InitialAlgorithms.getMaxPositiveWithNegativeReflect(array));
	}

}
