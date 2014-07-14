import java.util.Comparator;


public class BinaereSuche {
	
	public static final int NOT_FOUND = -1;

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static int binarySearch(Object[] array, Object key, Comparator cmp) {
		
		int anfang = 0;
		int ende = array.length - 1;
		int mitte = (anfang + ende)/2;
		
		while(cmp.compare(key, array[mitte]) != 0) {
			if(cmp.compare(key, array[mitte]) == 1)
				anfang = mitte + 1;
			if(cmp.compare(key, array[mitte]) == -1)
				ende = mitte - 1;
			
			mitte = (anfang + ende)/2;
		}
		
		if(key.equals(array[mitte]))
			return mitte;
		return NOT_FOUND;
	}

}
