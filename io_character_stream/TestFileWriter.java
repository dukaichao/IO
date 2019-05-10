package dkc.io_character_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-10
 * Time:18:49
 */
public class TestFileWriter {
    public static void main(String[] args) {
        //1.准备文件
        File file = new File("E:"+File.separator+"test1.txt");
        Writer writer = null;
        try {
            //2.创建输出流对象
            writer = new FileWriter(file);
            //3.输出内容
            writer.append("hello,Mr.Du.\n");
            writer.write("oh my god");
            //4.关闭流
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
