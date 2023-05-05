package telran.algorithm;

public class MemoryService {
public static int getMaxAvailableSize() {
	int right = Integer.MAX_VALUE;
	int left = 0;
	int middle = 0;
	byte[] array = null;
	while (left <= right) {
		middle = (left/2) + (right/2);
		try {
			array = new byte[middle];
			left = middle + 1;
		} catch(OutOfMemoryError e) {
			right = middle - 1;
		}
		array = null;
	}
	
	return middle;
	
}
}
