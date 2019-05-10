package dkc.io_IOS;

import java.io.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-10
 * Time:17:13
 */
public class TestOutputStream {
    public static void main(String[] args) {
        //1.准备文件
        String pathName = "E:"+ File.separator+"test.txt";
        File file = new File(pathName);
        OutputStream outputStream = null;
        try {
            //2.创建输出流对象
            outputStream = new FileOutputStream(file,true);

            //3.输出内容
            outputStream.write("hello world!\n".getBytes());
            outputStream.write(49);//表示字节  49对应的ascall码为1，向文件写入1
            //4.刷新
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
