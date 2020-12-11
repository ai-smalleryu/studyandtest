package IOFile;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.io.UnsupportedEncodingException;

/**
 * 解码字节-->字符串
 *
 */
public class ContentDecode {
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
        System.out.println(bytes1+"字节");
        System.out.println(bytes1.length);

        //还原为解码默认转到utf8 的字节
        String s1 = new String(bytes,0,bytes.length,"utf8");
        //乱码原因
        /**
         *字节数不够
         * 字符集不统一
         */
        System.out.println(s1+"转换回字符串");

        //bytes1转成16le的

    }
}

