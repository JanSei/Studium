package sorting;
public class Insertionsort implements IntSort {

    /**
     * Der Algorithmus InsertionSort (direktes Einfuegen) funktioniert wie folgt:
     * <p>
     * Das Teilfeld array[0] bis array[i-1] ist sortiert. Um i fuer den 
     * naechsten Durchlauf erhoehen zu koennen wird dieses Teilfeld bis auf
     * a[i] vergroessert. Damit dieses Teilfeld sortiert ist muss das
     * urspruengliche a[i] an der passenden Stelle eingefuegt werden.
     * <p>
     * Ein korrekter Ablauf wird durch die folgenden Ausgaben dargestellt:
     * <pre>
     * InsertionSort: [7| 1, 6, 2, 3, 8, 4, 5] 
     * InsertionSort: [1, 7| 6, 2, 3, 8, 4, 5] 
     * InsertionSort: [1, 6, 7| 2, 3, 8, 4, 5] 
     * InsertionSort: [1, 2, 6, 7| 3, 8, 4, 5] 
     * InsertionSort: [1, 2, 3, 6, 7| 8, 4, 5] 
     * InsertionSort: [1, 2, 3, 6, 7, 8| 4, 5] 
     * InsertionSort: [1, 2, 3, 4, 6, 7, 8| 5] 
     * InsertionSort: [1, 2, 3, 4, 5, 6, 7, 8]
     * </pre>
     * Der Strich | trennt den sortierten von dem unsortierten Teil.
     */
    public void sort(int[] array) {
		int tmp = 0;
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j > 0 && (array[j] < array[j-1]); j--) {
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
			}
			
		}
	}

}


















/*
int tmp = 0;
for (int i = 1; i < array.length; i++) {
	tmp = array[i];
	int j = i;
	while (j > 0 && array[j-1] > tmp) {
		array[j] = array[j-1];
		j--;
	}
	array[j] = tmp;
}
*/