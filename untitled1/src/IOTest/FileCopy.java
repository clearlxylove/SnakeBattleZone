package IOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String srcFilePath = "C:\\FileTest\\A\\lxy.png";
        String destFilePath = "C:\\FileTest\\B\\lxy.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            byte [] buf = new byte[1024];
            int readLen = 0;
            while((readLen = fileInputStream.read(buf))!=-1){
                //读取到后就写入 一边读一边写
                fileOutputStream.write(buf, 0, readLen); // 一定使用这个方法
            }
            System.out.println("拷贝OK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                //关闭输入输出流
                if(fileInputStream!=null){
                    fileInputStream.close();
                }
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
