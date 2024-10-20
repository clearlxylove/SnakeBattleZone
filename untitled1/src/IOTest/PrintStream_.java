package IOTest;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;

        out.println("Hello World");
        out.close();;

        System.setOut(new PrintStream("C:\\FileTest\\A\\lxy1.txt"));
        System.out.println("Hello 罗向杨");
    }
}
