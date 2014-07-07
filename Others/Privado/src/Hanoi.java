import javax.swing.JOptionPane;


public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		char a = 'A', b = 'B', c = 'C'; 
		
		x = Integer.parseInt(JOptionPane
				.showInputDialog("Bitte Hoehe von den Turm angeben: "));
		
		hanoi(x, a, b, c);
		

	}

	public static void hanoi(int n, char ausgang, char zwischen, char ziel) {
		if(n == 1)
			zieheScheibe(ausgang, ziel);
		else {
			hanoi(n-1, ausgang, ziel, zwischen);
			zieheScheibe(ausgang,  ziel);
			hanoi(n-1, zwischen, ausgang, ziel);
		}
	}
	
	public static void zieheScheibe(char von, char nach) {
		System.out.println("Scheibe von " + von + " zu " + nach);
	}
}
