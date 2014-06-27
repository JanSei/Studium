
public class Main {
	
	private static int[] array = {2, 5, 7, 4, 1, 3, 9, 8, 0, 6};
	
	public static void main(String[] args) {
//		SelectionSort meinSelectionsort = new SelectionSort();
		InsertionSort meinInsertionSort = new InsertionSort();
		
		// SelectionSort sortiert
		meinInsertionSort.sort(array);
		
	}

}