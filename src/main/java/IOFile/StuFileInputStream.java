package IOFile;

import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.util.Base64;

/**
 * @project studyandtest IOFile
 * @description:
 * @author: 玉雨钰瑜
 * @time: 7.8.21 12:25
 */
public class StuFileInputStream {
    public static void main(String[] args) {
        String base64Code = "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";

        byte[] data = Base64.getDecoder().decode(base64Code);
        //FileUtils.writeByteArrayToFile();
    }
}

class Test111 extends Thread {
    private boolean flag = false;
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+flag);
    }
    public static void main(String[] args) {
        Test111 abc = new Test111();
        abc.start();
        while (true){
            if(abc.flag){
                System.out.println("abc");
                break;
            }
        }
    }
}
