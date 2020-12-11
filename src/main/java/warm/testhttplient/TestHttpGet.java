package warm.testhttplient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * httpclient工具类测试使用
 */
public class TestHttpGet {
    public static void main(String[] args) throws IOException {
        //创建一个httpget对象
        String url="https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.1.7b71674eQOhSAg&id=539428289543&standard=1&user_id=101450072&cat_id=2&is_b=1&rn=4cad468db743a053bfa8c56344434e3d";
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml");
        httpGet.addHeader("Accept-Language", "zh-cn");
        httpGet.addHeader("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3983.2 Safari/537.36");
        //模拟浏览器实现请求
        //requestConfig
        RequestConfig build = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpGet.setConfig(build);
        //模拟http请求
        CloseableHttpClient build1 = HttpClientBuilder.create().build();
        CloseableHttpResponse execute = build1.execute(httpGet);//返回状态码
        HttpResponse re=execute;
        //相应信息判断是否成功

        try(Writer wri=new FileWriter("test.txt")) {

        if (re.getStatusLine().getStatusCode()==200) {
            //解析html
            HttpEntity entity = re.getEntity();
            //直接打印html
            String s = EntityUtils.toString(entity);//返回的就是html
            wri.write(s);
            //可以通过json解析
            System.out.println(s);

        }
        wri.flush();
        }
    }

}
