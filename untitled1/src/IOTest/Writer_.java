package IOTest;

import java.io.FileWriter;
import java.io.IOException;

public class Writer_ {
    public static void main(String[] args) {
        String filePath = "C:\\FileTest\\A\\note.txt";

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write('H');
            fileWriter.write("罗向杨最帅",0,4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
