package IOFile;

import java.io.UnsupportedEncodingException;

/**
 * 编码字符串--》字节
 *
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="此处表示主键约束";//一个字占三个字节
        byte[] bytes = s.getBytes();//编码拿到字节数组,默认为自己此工程使用的字符集
        System.out.println(bytes.length);
        for (byte bs:bytes
             ) {
            System.out.println(bs+"编码");
        }

        //编码其他字符集
        byte[] bytes1 = s.getBytes("UTF-16LE");//改写成使用此字符集
        System.out.println(bytes1.length);

    }
}

