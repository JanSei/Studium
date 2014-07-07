import javax.swing.*;

public class GGT {

	public static void main(String[] args) {

		int x, y;

		x = Integer.parseInt(JOptionPane
				.showInputDialog("Bitte erste Zahl eingeben"));
		y = Integer.parseInt(JOptionPane
				.showInputDialog("Bitte zweite Zahl eingeben"));

		while (x != y)
			if (x > y)
				x = x - y;
			else
				y = y - x;

		// Bessere Variante des ggT-Algorithmus
		/*
		 * while ((x > 0) && (y > 0)) 
		 * 		if(x >= y) x = x % y; 
		 * 		else y = y % x; 
		 * z = x + y;
		 */

		// Rekursive Variante des ggT-Algorithmus
		/*
		 * int ggT(int x, int y) { 
		 * 		if (x == y) return x; 
		 * 		else if (x > y) return ggT(x-y, y); 
		 * 		else return ggT(x, y-x); }
		 */

		// Rekursive Variante des ggT-Algorithmus aus den Internet geholt
		/*
		 * int ggt(int zahl1, int zahl2) { 
		 * 		if (zahl1 >= zahl2) { 
		 * 			if (zahl1 % zahl2 == 0) return zahl2; 
		 * 		else return ggt(zahl2, zahl1 - zahl2); 
		 * 		}
		 * 		else return ggt(zahl2, zahl1); }
		 */

		JOptionPane.showMessageDialog(null, "Ergebnis ist: " + x);
	}

}
