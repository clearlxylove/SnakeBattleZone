package IOTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework1 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\FileTest\\A\\lxy.txt";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        int lineNum = 0;

        while ((line = br.readLine())!=null) {
            System.out.println(++lineNum +" "+ line);
        }
        if(br!=null){
            br.close();
        }

    }
}
