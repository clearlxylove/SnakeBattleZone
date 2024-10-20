package IOTest;

import java.io.*;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\FileTest\\A\\lxy2.txt";

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)) ) ;
        pw.println("hallo 罗向杨");
        pw.close();

    }
}
