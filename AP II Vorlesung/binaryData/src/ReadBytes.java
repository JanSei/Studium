import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBytes {
    public static void main(String[] args) throws IOException {
        DataInputStream f = new DataInputStream(
                        new FileInputStream(args[0]));
        int n = 0;
        try {
        while (f.available() != 0) {
        	int b = f.readByte() & 0xff;
        	String stripped = Integer.toHexString(b);
        	String full = stripped.length() == 1 ? "0" + stripped : stripped;
        	System.out.print(full);
        	n = (n + 1) % 4;
        	if (n == 0) System.out.println();
        }
        }
        finally {
        	f.close();
        }
    }
}
