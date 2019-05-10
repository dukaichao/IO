package dkc.io_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-10
 * Time:15:51
 */
public class FileMethodTest {
    public static void main(String[] args) throws IOException {
        //文件的创建及删除
        createFile();

        //目录的操作
        directoryOperator();

        //文件信息
        fileMessage();

        //文件输出
        File file = new File("E:");
        printFile(file);

    }

    //文件的创建及删除
    public static void createFile() throws IOException {
        String pathName = "E:"+File.separator+"test";
        File file = new File(pathName);
        if(!file.exists()){
            System.out.println("调用creatNewFile()方法创建");
            file.createNewFile();
            System.out.println("创建成功");
        }else{
            file.delete();
            System.out.println("该文件已经存在，不需要创建");
        }
    }

    //目录的操作
    public static void directoryOperator(){
        String pathName = "E:"+File.separator+"Test"+File.separator+"prc";
        File file = new File(pathName);
        System.out.println(file.getParentFile());
        file.mkdirs();
    }

    //文件信息
    public static void fileMessage() throws IOException {
        String pathName = "E:"+File.separator+"Test"+File.separator+"prc"+File.separator+"test.txt";
        File file = new File(pathName);
        System.out.println("文件是否存在："+file.exists());
        System.out.println("是否是文件："+file.isFile());
        System.out.println("是否是目录："+file.isDirectory());
        Date date = new Date(file.lastModified());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
        String res = simpleDateFormat.format(date);
        System.out.println("最后修改时间："+res);
        System.out.println("文件大小："+file.length());
    }

    //打印一个目录下的所有文件
    public static void printFile(File file){
        if(file.exists()){
            if(file.isDirectory()){
                File[] file1 = file.listFiles();
                if(file1!=null){
                    for(File file2 : file1){
                        printFile(file2);
                    }
                }
            }else{
                System.out.println(file.getName());
            }
        }
    }
}
