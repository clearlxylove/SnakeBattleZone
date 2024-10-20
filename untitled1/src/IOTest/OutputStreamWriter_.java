package IOTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\FileTest\\A\\lxy.txt";
        String charSet = "UTF-8";

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),charSet);
        osw.write("hi,罗向杨");
        osw.close();
        System.out.println("按照 " + charSet + "保存文件成功");
    }
}
