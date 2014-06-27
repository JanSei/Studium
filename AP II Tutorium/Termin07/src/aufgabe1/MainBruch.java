package aufgabe1;

import aufgabe2.StringLengthComparator;

public class MainBruch {
	
	public static void main(String[] args) {
		
		Bruch bruch1 = new Bruch(2, 5);
		Bruch bruch2 = new Bruch(3, 7);
		
		Bruch bruch3 = bruch1.addiere(bruch2);
		System.out.println("Addition: ");
		System.out.println(bruch1);
		System.out.println(bruch2);
		System.out.println(bruch3);
		
		bruch3 = bruch1.multipliziere(bruch2);
		System.out.printf("%nMultplikation: %n");
		System.out.println(bruch1);
		System.out.println(bruch2);
		System.out.println(bruch3);
		
		bruch3 = bruch1.dividiere(bruch2);
		System.out.println("%nDivision: %n");
		System.out.println(bruch1);
		System.out.println(bruch2);
		System.out.println(bruch3);
		
		bruch3 = bruch1.subtrahiere(bruch2);
		System.out.println("%nSubtraktion: %n");
		System.out.println(bruch1);
		System.out.println(bruch2);
		System.out.println(bruch3);
		
	}

}
