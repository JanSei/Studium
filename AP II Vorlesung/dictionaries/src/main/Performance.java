package main;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import util.BucketDictionary;
import util.Dictionary;
import util.HashDictionary;
import util.LinearDictionary;
import util.ScatterTable;
import util.TreeDictionary;

/**
 * Perform efficiency measurements on dictionary classes.
 * 
 * args[0]: name of class.
 * args[1]: number of keys.
 * args[2]: initial table size (optional).
 */
public final class Performance {
    private Performance() {}
    
    private static final double NANO_SECOND = 1e-9;
    private static final int ONE_SECOND = 1000000000;
    static int searchEquals;
    static int searchCompare;
    static int searchHashCode;

    /**
     * Class <code>Key</code> substitutes class <code>String</code> in the use
     * as search key.
     * It counts all calls to <code>equals</code>, <code>compareTo</code>,
     * and <code>hashCode</code>.
     * @author Erich Ehses
     */
    private static class Key implements Comparable<Object> {
        private static int nEquals = 0;
        private static int nCompareTo = 0;
        private static int nHashCode = 0;
        
        private final String data;
        
        private Key(String data) {
            this.data = data;
        }
        
        public boolean equals(Object obj) {
            nEquals++;
            if (!(obj instanceof Key)) return false;
            return this.data.equals(((Key) obj).data);
        }

        public int compareTo(Object o) {
            nCompareTo++;
            return data.compareTo(((Key)o).data);
        }
        
       public int hashCode() {
            nHashCode++;
            return data.hashCode();
        }

        /**
         * Get number of calls to <code>compareTo</code>.
         * @return number of calls.
         */
        public static int getNCompareTo() {
            return nCompareTo;
        }

        /**
         * Get number of calls to <code>equals</code>.
         * @return number of calls.
         */
        public static int getNEquals() {
            return nEquals;
        }

        /**
         * Get number of calls to <code>hashCode</code>.
         * @return number of calls.
         */
        public static int getNHashCode() {
            return nHashCode;
        }

        /**
         * Reset Number of calls to <code>compareTo</code>.
         */
        public static void clearNCompareTo() {
            nCompareTo = 0;
        }

        /**
         * Reset Number of calls to <code>equals</code>.
         */
        public static void clearNEquals() {
            nEquals = 0;
        }

        /**
         * Reset Number of calls to <code>hashCode</code>.
         */
        public static void clearNHashCode() {
            nHashCode = 0;
        }

    }
    static final int STRING_LENGTH = 10;
    static final Random r = new Random();

    static double buildTable(Dictionary d, Key[] keys) {
        String obj = "dummy";
        int count = 0;
        long startTime = System.nanoTime();
        long minEndTime = startTime + ONE_SECOND;
        while (System.nanoTime() < minEndTime) {
            count++;
            for (Key k : keys) d.put(k, obj);
        }
        return (System.nanoTime() - startTime) * NANO_SECOND / count;
    }

    static double searchTable(Dictionary d, Key[] keys) {
        int count = 0;
        boolean isFirstTime = true;
        
        // Reset all counters
        Key.clearNEquals();
        Key.clearNCompareTo();
        Key.clearNHashCode();
        
        long startTime = System.nanoTime();
        long minEndTime = startTime + ONE_SECOND;
        while (System.nanoTime() < minEndTime) {
            count++;
            for (int i = 0; i < keys.length; i++)
                d.get(keys[i]);
            // take the results from the first iteration.
            if (isFirstTime) {
                searchEquals = Key.getNEquals();
                searchCompare = Key.getNCompareTo();
                searchHashCode = Key.getNHashCode();
                isFirstTime = false;
            } 
        }
        return (System.nanoTime() - startTime) * NANO_SECOND / count;
    }
    
    static double iterateTable(Dictionary d) {
        int count = 0;
        long startTime = System.nanoTime();
        long minEndTime = startTime + ONE_SECOND;
        while (System.nanoTime() < minEndTime) {
            count++;
            for (Iterator<?> iter = d.iterator(); iter.hasNext();)
                iter.next();
        }
        return (System.nanoTime() - startTime) * NANO_SECOND / count;
    }
    
    static void randomize(Key[] keys) {
        for (int i=0; i<keys.length; i++) {
            int index1 = r.nextInt(keys.length);
            int index2 = r.nextInt(keys.length);
            if (index1 != index2) {
                Key t = keys[index1];
                keys[index1] = keys[index2];
                keys[index2] = t;
            }
        }
    }

    static double clearTable(Dictionary d, Key[] keys) {
        long startTime = System.nanoTime();
        try {
            for (int i = 0; i < keys.length; i++)
                d.remove(keys[i]);  
        } catch (UnsupportedOperationException e) {
            System.err.println("remove is not supported");
            return 0.0;
        }
        return (System.nanoTime() - startTime) * NANO_SECOND;
    }

    static Key[] buildKeys(int n) {
        Key[] keys = new Key[n];
        StringBuffer s = new StringBuffer("0123456");
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                s.setCharAt(j, (char) (r.nextInt(60) + 32));
            }
            keys[i] = new Key(s.toString());
        }
        return keys;
    }

    public static void main(String[] args) throws Exception {
    	String[] NAMES = { "Linear", "Bucket", "Hash", "Tree" };
    	Class<?>[] ds = {
    			LinearDictionary.class, BucketDictionary.class,
    			HashDictionary.class, TreeDictionary.class};
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Dictionary-Test");
		System.out.println("Nummer des Suchverfahrens");
		int searchingMethod = scanner.nextInt();
		if (searchingMethod < 0 || searchingMethod >= NAMES.length) {
			System.err.println("erlaubt ist 0 - " + (NAMES.length - 1));
			System.exit(1);
		}
		System.out.println(NAMES[searchingMethod]);
        Dictionary d = (Dictionary) ds[searchingMethod].newInstance();
        Dictionary dTemp = (Dictionary)ds[searchingMethod].newInstance();
        System.out.print("Anzahl der Keys: ");
        int nKeys = scanner.nextInt();
        System.out.print("Anfangskapazitaet (< 0: fest):");
        int cap = scanner.nextInt();
        if (cap == 0) cap = 11;
        d.setTableSize(Math.abs(cap));
        if (d instanceof ScatterTable && cap < 0)
            ((ScatterTable)d).setResizeable(false);
        Key[] keys = buildKeys(nKeys);
        System.out.println(
            "\nMeasurements for class " + d.getClass().getName() + ":\n");
        System.out.println("Number of keys: " + keys.length);
        
        // give Hotspot-Compiler a chance to do its work unobserved:
        buildTable(dTemp, keys);
        searchTable(dTemp, keys);
        
        
        // now start real job
        double buildTime = buildTable(d, keys);
        if (d instanceof ScatterTable) {
            System.out.println("collisions: " +
                ((ScatterTable)d).collisionLength());
        }
        double searchTime = searchTable(d, keys);
        double iterationTime = iterateTable(d);
        randomize(keys);
        double removeTime = clearTable(d, keys);
        System.out.printf("total build time: %.2g%n", buildTime);
        System.out.printf("total search time: %.2g%n", searchTime);
        System.out.printf("iteration time: %.2g%n", iterationTime);
        System.out.printf("total remove time: %.2g%n", removeTime);
        System.out.printf("put/key: %.2g%n", buildTime / keys.length);
        System.out.printf("get/key: %.2g%n", searchTime / keys.length);
        System.out.printf("iteration/key: %.2g%n", iterationTime / keys.length);
        System.out.printf("remove/key: %.2g%n", removeTime / keys.length);
        if (d.size() != 0)
            System.out.println("final size: " + d.size());
        if (searchEquals != 0)
            System.out.println("#equals: " + searchEquals);
        if (searchCompare != 0)
            System.out.println("#compareTo: " + searchCompare);
        if (searchHashCode != 0)
            System.out.println("#hashCode: " + searchHashCode);
        scanner.close();
    }
}
