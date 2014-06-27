import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class WriteData {
    public static void main(String[] args) throws Exception {
        DataOutputStream f = new DataOutputStream(
                        new FileOutputStream("Data.dat"));
        f.writeUTF("100");
        f.writeShort(100);
        f.writeInt(100);
        f.writeFloat(0.100f);
        f.writeDouble(0.100);
        f.writeUTF("ENDE");
        f.close();
    }

}
