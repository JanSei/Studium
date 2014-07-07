import javax.swing.JOptionPane;


public class PythagoräischenZahlentripel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		
		n = Integer.parseInt(JOptionPane
				.showInputDialog("Obergrenze von a und b"));
		
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				int aabb = a*a + b*b;
				int c = (int) Math.sqrt(aabb);
				if(aabb == c*c)
					System.out.println("(" + a +", " + b + ", " + c + ")");
//					JOptionPane.showMessageDialog(null, "(" + a +", " + b + ", " + c + ")");
				
			}
			
		}
		

	}

}
