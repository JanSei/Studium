package main;
import java.util.Scanner;

import util.BucketDictionary;
import util.Dictionary;
import util.HashDictionary;
import util.LinearDictionary;
import util.TreeDictionary;

/**
 * Testet die verschiedenen Dictionary Klassen
 */
public class Behaviour {
    /**
     * allgemeine Testfunktion
     * @param d zu testendes Dictionary-Objekt
     */
    public static void test(Dictionary d) {
        System.out.println("Zunaechst eintragen:");
        System.out.println("  Anna");
        d.put("Anna", "huebsch");
        System.out.println("  Paul");
        d.put("Paul", "faul");
        System.out.println("  Martina");
        d.put("Martina", "klug");
        System.out.println("  Hans");
        d.put("Hans", "dumm");
        System.out.println("  Alfons");
        d.put("Alfons", "eifrig");
        //assert d.size() == 5;
        
        System.out.println("Komplette Ausgabe:");
        System.out.println(d);

        System.out.println("Was ist Hans?");
        String wert;
        if (d.contains("Hans")) {
            wert = (String)d.get("Hans");
            System.out.println("  Hans ist "+wert);
        }
        else
            System.out.println("  Hans wurde nicht gefunden!");

        System.out.println("Was ist Karin?");
        wert = (String) d.get("Karin");
        if (wert != null) {
            System.out.println("  Karin ist "+wert);
        }
        else
            System.out.println("  Karin wurde nicht gefunden!");
    }
    
	private static final String[] NAMES = { "Linear", "Bucket", "Hash", "Tree" };

    public static void main(String[] argv) {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Dictionary-Test");
		System.out.println("Nummer des Suchverfahrens");
		int searchingMethod = scanner.nextInt();
		if (searchingMethod < 0 || searchingMethod >= NAMES.length) {
			System.err.println("erlaubt ist 0 - " + (NAMES.length - 1));
			System.exit(1);
		}
		System.out.println(NAMES[searchingMethod]);
        Dictionary d = null;
        switch (searchingMethod) {
        case 3: d = new TreeDictionary(); break;
        case 2: d = new HashDictionary(); break;
        case 1: d = new BucketDictionary(); break;
        case 0: d = new LinearDictionary(); break;
        }
        // der eigentliche Test
        System.out.println("getestet wird Dictionary: "+d.getClass().getName());
        test(d);
        System.out.println();
        scanner.close();
    }
}