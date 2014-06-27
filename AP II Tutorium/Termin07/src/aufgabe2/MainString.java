package aufgabe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainString {

	public static void main(String[] args) {

		// Variante mit eigener Comparator Klasse
		ArrayList<String> meinSatz = new ArrayList<String>();
		meinSatz.add("ein");
		meinSatz.add("kurzer");
		meinSatz.add("test");

		Collections.sort(meinSatz, new StringLengthComparator());
		System.out.println(meinSatz);

		// Zum Vergleich Ÿber einen Anonymen Aufruf
		ArrayList<String> meinZweiterSatz = new ArrayList<String>();
		meinZweiterSatz.add("ein");
		meinZweiterSatz.add("zweiter");
		meinZweiterSatz.add("test");

		Collections.sort(meinZweiterSatz, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return (int) Math.signum(s1.length() - s2.length());
			}

		});

		System.out.println(meinZweiterSatz);
	}

}
