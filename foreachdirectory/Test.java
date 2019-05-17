package dkc.foreachdirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-17
 * Time:14:26
 */
public class Test {
    static int i;
    public static void main(String[] args) throws IOException {
        Path start = FileSystems.getDefault().getPath("E:"+ File.separator+"前端代码");
        Files.walk(start)
                .filter(path -> path.toFile().isFile())
                .filter(path -> path.toString().endsWith(".html"))
                .forEach(System.out::println);
        System.out.println("=============================");
        printFile(new File("E:"+ File.separator+"前端代码"));
        System.out.println("ttssggs.jpg".endsWith(".html"));
    }

    public static void printFile(File file){
        if(file.isDirectory()){
            File[] file1 = file.listFiles();
            for(File file2 : file1){
                if(file2!=null){
                    printFile(file2);
                }
            }
        }else{
            if(file.toString().endsWith(".html")){
                System.out.println(++i+","+file);
            }
        }
    }
}
