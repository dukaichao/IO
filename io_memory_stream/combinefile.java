package dkc.io_memory_stream;

import java.io.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-11
 * Time:9:55
 */
public class combinefile {
    public static void main(String[] args) throws IOException {
        File file1 = new File("E:"+File.separator+"copy1.txt");
        File file2 = new File("E:"+File.separator+"copy2.txt");
        File file3 = new File("E:"+File.separator+"new.txt");
        InputStream in1 = new FileInputStream(file1);
        InputStream in2 = new FileInputStream(file2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream out = new FileOutputStream(file3,true);
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = in1.read(bytes))!=-1){
            baos.write(bytes,0,len);
        }
        while((len = in2.read(bytes))!=-1){
            baos.write(bytes,0,len);
        }
        byte[] bytes1 = baos.toByteArray();
        out.write(bytes1);
        in1.close();
        in2.close();
        baos.close();
        out.close();
    }

    public static void code1() throws IOException {
        File file1 = new File("E:"+File.separator+"copy1.txt");
        File file2 = new File("E:"+File.separator+"copy2.txt");
        InputStream in = new FileInputStream(file2);
        OutputStream out = new FileOutputStream(file1,true);
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        out.flush();
        in.close();
        out.close();
    }
}
