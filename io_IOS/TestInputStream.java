package dkc.io_IOS;

import java.io.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-10
 * Time:17:02
 */
public class TestInputStream {
    public static void main(String[] args) {
        String pathName = "E:"+ File.separator+"test.txt";
        File file = new File(pathName);
        if(file.exists()&&file.isFile()){
            try {
                InputStream inputStream = new FileInputStream(file);
                int b = 0;
                byte[] bytes = new byte[1024];
                while((b = inputStream.read(bytes))!=-1){
                    System.out.print(new String(bytes,0,b));
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
