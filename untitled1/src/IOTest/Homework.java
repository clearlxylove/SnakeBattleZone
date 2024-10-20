package IOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws IOException {
        String directoryPath = "C:\\FileTest\\A\\mytemp";
        File file = new File(directoryPath);
        if(!file.exists()){
            if(file.mkdirs()){
                System.out.println("创建 " + directoryPath + " 成功");
            }else{
                System.out.println("创建失败");
            }
        }

        String filePath = directoryPath + "\\hello.txt";
        File file1 = new File(filePath);
        if(!file1.exists()){
            if(file1.createNewFile()){
                System.out.println("创建 " + filePath + " 成功");
            }else{
                System.out.println("创建失败");
            }
        }else{
            System.out.println("已经存在");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write("hello world".getBytes());
        fileOutputStream.close();
    }
}
