
public class MysteriousCast {
    public static void main(String[] args) {
        dummy();
    }
    
	public static void dummy() {
		double a = 1.4;
		int x = (int) a;
		int xa = 200;
		Object b = (Object) "123";
		String c = (String) b;
		Integer xi = x;
		Integer yi = x;
		Integer ai = xa;
		Integer bi = xa;
		String s = ((Integer) 3).toString();
		String t = Integer.valueOf(3).toString();
		String ap = "a" + x + xi;
	}
}
