import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObjects {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream f = new ObjectOutputStream(
                        new FileOutputStream("Objects.dat"));
        f.writeObject("100");
        f.writeObject((short) 100);
        f.writeObject(100);
        f.writeObject(100f);
        f.writeObject(100.0);
        f.writeObject("ENDE");
        f.close();
    }

}
