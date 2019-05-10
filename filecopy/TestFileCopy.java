package dkc.filecopy;

import java.io.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-10
 * Time:19:41
 */
public class TestFileCopy {
    public static void main(String[] args) {
        String src = "E:"+ File.separator+"test.txt";
        String dest = "E:"+ File.separator+"java"+File.separator+"java1"+File.separator+"test4";
        filecopy1(src,dest);
    }

    //字节流拷贝
    public static void filecopy(String src,String dest){
        checkArgumentNotNull(src,"source file path must be not null/empty");
        checkArgumentNotNull(dest,"dest file path must be not null/empty");
        File srcFile = new File(src);
        checkFile(srcFile,"source file path must be file and exists");
        File destFile = new File(dest);
        checkAndMkParentFile(destFile,"");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);
            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = is.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符流拷贝
    public static void filecopy1(String src,String dest){
        checkArgumentNotNull(src,"source file path must be not null/empty");
        checkArgumentNotNull(dest,"dest file path must be not null/empty");
        File srcFile = new File(src);
        checkFile(srcFile,"source file path must be file and exists");
        File destFile = new File(dest);
        checkAndMkParentFile(destFile,"destFile must be not null");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(srcFile);
            writer = new FileWriter(destFile);
            int len = 0;
            char[] chars = new char[1024];
            while((len = reader.read(chars))!=-1){
                writer.write(chars,0,len);
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 检查参数不能为空，如果为null，抛出异常
    public static void checkArgumentNotNull(Object obj,String msg){
        if(obj == null){
            throw new IllegalArgumentException(msg);
        }
        if(obj instanceof  CharSequence && ((CharSequence) obj).length() == 0){
            throw new IllegalArgumentException(msg);
        }
    }

    //检验原路径是否合法
    public static void checkFile(File file,String msg){
        if(file == null || file.isDirectory() || !file.exists()){
            throw new IllegalArgumentException(msg);
        }
    }

    //检验目的路径的父路径是否存在，不存在就创建
    public static void checkAndMkParentFile(File file,String msg){
        if(file == null){
            throw new IllegalArgumentException(msg);
        }
        if(!file.getParentFile().exists()){
            boolean rs = file.getParentFile().mkdirs();
            if(!rs){
                throw new RuntimeException("Create file "+ file.getAbsolutePath()+" parent directory failed");
            }
        }
    }
}
