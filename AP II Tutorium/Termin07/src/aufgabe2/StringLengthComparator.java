package aufgabe2;

import java.util.Comparator;

public class StringLengthComparator implements
		Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1 == null) throw new NullPointerException();
		if(o1 == null & o2 == null) return 0;
		return (int) Math.signum(o1.length() - o2.length());
	}

}
