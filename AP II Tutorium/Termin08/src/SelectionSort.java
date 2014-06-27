
public class SelectionSort {

	public void sort(int[] array) {
		int tmp = 0, min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[min] > array[j]) min = j;
			}
			tmp = array[min];
			array[min] = array[i];
			array[i] = tmp;
		}
	}
}
