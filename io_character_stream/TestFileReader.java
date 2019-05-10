package dkc.io_character_stream;

import java.io.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-10
 * Time:18:57
 */
public class TestFileReader {
    public static void main(String[] args) {
        File file = new File("E:"+File.separator+"test1.txt");
        if(file.exists()&&file.isFile()){
            Reader reader = null;
            try {
                reader = new FileReader(file);
                char[] chars = new char[1024];
                int len = 0;
                while((len = reader.read(chars))!=-1){
                    System.out.print(new String(chars,0,len));
                }
                reader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
