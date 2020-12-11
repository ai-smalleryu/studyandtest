package warm;

import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author Administrator
 * @PACKAGE_NAME: warm
 * @PROJECT_NAME: studyandtest
 * @DESCRIPTION:
 * @USER: Administrator
 * @DATE: 2020/9/1 15:18
 */
public class TestWarm {
    private static String Post(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        ProtocolVersion protocolVersion = post.getProtocolVersion();
        System.out.println(protocolVersion.getProtocol());
        try {
            //该网页需要认证（用户名、密码）
            HttpClientContext context = new HttpClientContext();
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("admin", "admin1q2w3e"));
            context.setCredentialsProvider(credentialsProvider);
            CloseableHttpResponse execute = client.execute(post, context);
            //----以下一样
            HttpEntity entity = execute.getEntity();
            InputStream in = entity.getContent();
            StringBuilder builder = new StringBuilder();
            BufferedReader bufreader = new BufferedReader(new InputStreamReader(in));
            for (String temp = bufreader.readLine(); temp != null; temp = bufreader.readLine()) {
                builder.append(temp);
            }
            return builder.toString();
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            String post = Post("http://172.16.13.18:6080/service/plugins/services");
            System.out.println(post.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
