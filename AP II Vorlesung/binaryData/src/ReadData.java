import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadData {
    public static void main(String[] args) throws Exception {
        DataInputStream f = new DataInputStream(
                        new FileInputStream("Data.dat"));
        String hundert = f.readUTF();
        short h1 = f.readShort();
        int h2 = f.readInt();
        float f1 = f.readFloat();
        double f2 = f.readDouble();
        String ende = f.readUTF();
        f.close();
        System.out.println("String: " + hundert);
        System.out.println("short: " + h1);
        System.out.println("int: " + h2);
        System.out.println("float: " + f1);
        System.out.println("double: " + f2);
        System.out.println("Schluss: " + ende);
    }
}
