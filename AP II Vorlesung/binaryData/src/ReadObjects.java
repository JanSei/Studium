import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObjects {

    public static void main(String[] args) throws Exception {
        ObjectInputStream f = new ObjectInputStream(
                        new FileInputStream("Objects.dat"));
        Object hundert = f.readObject();
        Object h1 = f.readObject();
        Object h2 = f.readObject();
        Object f1 = f.readObject();
        Object f2 = f.readObject();
        Object ende = f.readObject();
        f.close();
        print(hundert);
        print(h1);
        print(h2);
        print(f1);
        print(f2);
        print(ende);
    }
    
    private static void print(Object x) {
        String completeName = x.getClass().getName();
        int indexOfLastDot = completeName.lastIndexOf('.');
        String className = completeName.substring(indexOfLastDot + 1);
        System.out.println(className + ": " + x);
    }
}
