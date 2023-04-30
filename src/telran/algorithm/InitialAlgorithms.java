package telran.algorithm;

public class InitialAlgorithms {
	public static void sortShortPositive(short[] array) {
		int[] helper = new int[Short.MAX_VALUE];
		// helper[index] => count of occurrences for number index in array
		// helper[1000] = 2 => number 1000 occurs twice in the source array
		// helper[2] = 0;
		for (int i = 0; i < array.length; i++) {
			helper[array[i]]++;
		}
		int index = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[index++] = (short) i;
			}
		}

	}

	public static boolean isSum2(short[] array, short sum) {
		boolean res = false;

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] <= sum) {
				for (int j = i + 1; j < array.length; j++) {
					if (sum == (short) (array[i] + array[j])) {
						res = true;
						break;
					}
				}
			}
			if (res) {
				break;
			}
		}
		return res;
	}

	public static short getMaxPositiveWithNegativeReflect(short[] array) {
		short max = -1;
		short isReflective = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0 && array[i] > max) {
				max = array[i];
				for (int j = 0; j < array.length; j++) {
					if (array[j] < 0 && max + array[j] == 0) {
						isReflective = max;
						break;
					}
				}
			}
		}
		return isReflective;
	}


	
	public static void bubbleSort(short[] array) {
		// sorting with bubble sort algorithm
		int size = array.length;
		boolean flUnsorted = false;
		do {
			size--;
			flUnsorted = false;
			for (int i = 0; i < size; i++) {
				if (array[i] > array[i + 1]) {
					short tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					flUnsorted = true;
				}
			}
		} while (flUnsorted);

	}
}