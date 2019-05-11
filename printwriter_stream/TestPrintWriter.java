package dkc.printwriter_stream;

import java.io.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-11
 * Time:10:49
 */
public class TestPrintWriter {
    public static void main(String[] args) {
        String pathName = "E:"+ File.separator+"zzc.txt";
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(pathName,true))){
            pw.write("姓名：渣渣超\n");
            pw.write("年龄：18\n");
            pw.printf("身高 %.1f cm\n",178.5);
        }catch(IOException e){
            System.out.println();
        }
    }
}
