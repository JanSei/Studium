package main;

import java.util.Random;
import java.util.Scanner;

import util.BucketDictionary;
import util.Dictionary;
import util.HashDictionary;
import util.LinearDictionary;
import util.TreeDictionary;

/**
 * Testtreiber fuer den Test von Sortieralgorithmen.
 */
public final class Test {
	private Test() {}

	private static Dictionary d;
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Timer stoppt die Zeit.
	 */
	private static class Timer {
		private long startTime = System.currentTimeMillis();

		private void reset() {
			startTime = System.currentTimeMillis();
		}

		private double getTime() {
			return (System.currentTimeMillis() - startTime) / 1000.0;
		}
	}

	// private Datenkomponenten:
	private static Integer[] data;
	private static final Timer timer = new Timer();
	private static final String[] NAMES = { "Linear", "Bucket", "Hash", "Tree" };
	private static final Random r = new Random();

	/* einfache Hilfsgroesse, zwecks Modularisierung */
	private static int repetitions;

	/**
	 * Testprogramm fuer das Sortieren.
	 */
	public static void main(String[] args) {
		System.out.println("Nummer des Suchverfahrens");
		int searchingMethod = scanner.nextInt();
		if (searchingMethod < 0 || searchingMethod >= NAMES.length) {
			System.err.println("erlaubt ist 0 - " + (NAMES.length - 1));
			System.exit(1);
		}
		System.out.println(NAMES[searchingMethod]);
		System.out.println("Feldgroesse");
		int groesse = scanner.nextInt();
		init(searchingMethod, groesse);
		doMeasurement(searchingMethod);
		printResults(searchingMethod, groesse);
	}

	private static void doMeasurement(int searchingMethod) {
		repetitions = 0;
		timer.reset();
		while (timer.getTime() < 1.0) {
			repetitions++;
			for (int i : data)
				d.get(i);
		}
	}

	private static void init(int searchingMethod, int size) {
		data = new Integer[size];
		switch (searchingMethod) {
		case 0:
			d = new LinearDictionary();
			break;
		case 1:
			d = new BucketDictionary();
			break;
		case 2:
			d = new HashDictionary();
			break;
		case 3:
			d = new TreeDictionary();
		}
		d.setTableSize(2 * size);
		int maxNum = size * 10;
		for (int i = 0; i < size; i++) {
			data[i] = r.nextInt(maxNum);
			d.put(data[i], 1);
		}
	}

	/**
	 * Ausgabe der Ergebnisse.
	 * 
	 * @param groesse
	 *            Groesse des Feldes.
	 * @param totalTime
	 *            Gesamtzeit fuer das Sortieren.
	 * @param repetitions
	 *            Anzahl der Sortieraufrufe.
	 */
	private static void printResults(int sortingMethod, int groesse) {
		double totalTime = timer.getTime();
		double time = totalTime / repetitions;
		System.out.printf("%nGesamtzeit: %.2g%n", time);
		System.out.printf("Zeit/N: %.2g%n", time / groesse);
	}
}
