
public class InsertionSort {
	
	public void sort(int[] array) {
		int tmp = 0;
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j > 0 && (array[j] < array[j-1]); j--) {
//				if (array[j] > array[i]) {
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
//				}
			}
			
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}

}
