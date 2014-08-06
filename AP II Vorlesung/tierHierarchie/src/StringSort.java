import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class StringSort {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String[] strings = {				"Es war einmal",
				"datt is sch�n un joot",
				"�bung 1",
				"�rger und Frust",
				"�berfl�ssig",
				"Ueberfluss",
				"Philip J. Fry, Intergalactic Delivery Boy"
		};
		
		String[] sortierung1 = Arrays.copyOf(strings, strings.length);
		Arrays.sort(sortierung1);
		String[] sortierung2 = Arrays.copyOf(strings, strings.length);
		final Comparator<Object> s = Collator.getInstance(Locale.GERMANY);
		Arrays.sort(sortierung2, new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				return - s.compare(o1, o2);
			}		
		}
		);
		print("Fall1", sortierung1);
		System.out.println();
		print("Fall2", sortierung2);
	}
	
	private static void print(String title, String[] strings) {
	    System.out.println(title+"\n");
	    for (String line : strings)
	    	System.out.println(line);
	}
}

