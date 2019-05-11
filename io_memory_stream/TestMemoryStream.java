package dkc.io_memory_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-11
 * Time:9:13
 */
public class TestMemoryStream {
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("123456".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int tmp = 0;
        while((tmp = in.read())!=-1){
            int mmp = Character.toUpperCase(tmp);
            out.write(mmp);
        }
        byte[] bytes = out.toByteArray();
        System.out.println(new String(bytes));
        out.flush();
    }
}
