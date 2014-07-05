import javax.swing.*;

public class GGT {
	
	public static void main(String[] args) {
		
		int x, y;
		
		x = Integer.parseInt(JOptionPane.showInputDialog("Bitte erste Zahl eingeben"));
		y = Integer.parseInt(JOptionPane.showInputDialog("Bitte zweite Zahl eingeben"));
		
		while (x != y)
			if(x > y) x = x-y;
			else y = y-x;
		
		JOptionPane.showMessageDialog(null, "Ergebnis ist: " + x);
	}

}
