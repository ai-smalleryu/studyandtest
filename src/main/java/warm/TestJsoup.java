package warm;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 解析简单的html
 */
public class TestJsoup {
    public static void main(String[] args) throws IOException {
        String html = "<html>" +
                "<body>" +
                "<h2>Hello World!</h2>" +
                "<p>htmlpppp</p>" +
                "</body>" +
                "</html>";
        //将字符串的html解析成文档
        Document doc = Jsoup.parse(html);

        //从url地址获取dom解析
        Connection connect = Jsoup.connect("http://www.baidu.com");//连接到url
        Document document = connect.get();
        //网页的全部信息
        //System.out.println(document);
        System.out.println(document.select("title"));
        System.out.println("-----------------------");
        String title = document.title();
        System.out.println(title);
        System.out.println("+++++++++++++++++++++++++++++++");
        //获取百度的，通过id
        Element eid = document.getElementById("u1");
        Elements a = eid.getElementsByTag("a");//获取a标签的内容,返回的是一个集合
        for (Element element : a) {
            String href = element.attr("href");//获取到href的内容
            System.out.println(href);
        }
        System.out.println("选择器获取到html信息");
        String s="<p id='asd'>haha<a href='http://www.baidu.com'><b><p class='abc'>测试</P></b></a>link.</p>";
        //解析器解析
        Document parse = Jsoup.parse(s);//解析html
        System.out.println(parse);
        System.out.println("================================");
        //查找第一个a元素
        Elements a1 = parse.select("a");//获取所有的a标签
        Element a2 = parse.select("a").first();//获取第一个q标签
        //取得标签中的文本
        String text = parse.body().text();//获取所有的文本信息
        System.out.println(text+"文本信息");
        System.out.println("--------------------------------");
        //获取连接地址
        String href = a2.attr("href");
        System.out.println(href);
        System.out.println("__________________________");
        String text1 = a2.text();
        System.out.println("获取标签内的信息"+text1);
        //通过样式获取标签信息
        //与css选择器类似
        Elements select = parse.select(".abc");//获取class是abc的所有信息
        String text2 = select.first().text();
        System.out.println(text2+"通过class选择器获得的信息");
        Elements select1 = parse.select("#asd");//获取id是asd的所有信息
        String text3 = select1.first().text();
        System.out.println("通过id选择器获得信息"+text3);
        Elements select2 = parse.select("#asd .abc");//获取idasd下的class是abc的信息
        for (Element element : select2) {
            String abc = element.attr("abc");
            System.out.println(abc);
        }
    }

}
