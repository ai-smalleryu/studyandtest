package warm.testURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

/**
 * 通过原生的urlconnection模拟爬虫实现
 */
public class TestURLConnection {
    public static void main(String[] args) {
        URLConnection urlConnection = null;
        URL url = null;
        String r="http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        Pattern p=Pattern.compile(r);//正则表达式
        //爬取的网站
        try {
            url=new URL("http://www.baidu.com");

            //创立连接
            urlConnection=url.openConnection();

            //获取返回的输入流
            InputStream inputStream = urlConnection.getInputStream();
            //创建读取管道
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            //读取br、的信息
            String buf=null;
            //通过url正则匹配 找到符合的url连接
            while ((buf=br.readLine())!=null){
                java.util.regex.Matcher m=p.matcher(buf);
                while (m.find()){
                    String group = m.group();
                    System.out.println(group);
                }
            }
            System.out.println("爬取完成");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
