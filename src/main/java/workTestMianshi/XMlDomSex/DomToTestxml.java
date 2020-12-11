package workTestMianshi.XMlDomSex;

import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Iterator;

public class DomToTestxml {

}
/**
 * @Author: cxx
 * Dom操作xml
 * @Date: 2018/5/29 20:19
 */
 class DomDemo {
    //用Element方式
    public static void element(NodeList list){
        for (int i = 0; i <list.getLength() ; i++) {
            Element element = (Element) list.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    //获取节点
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    //获取节点值
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }

    public static void node(NodeList list){
        for (int i = 0; i <list.getLength() ; i++) {
            Node node = list.item(i);//获取根节点
            NodeList childNodes = node.getChildNodes();//获取子节点
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    System.out.print(childNodes.item(j).getNodeName() + ":子节点值");//获取子节点名称
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());//获取子节点值
                }
            }
        }
    }

    public static void main(String[] args) {
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("E:\\JavaTest\\untitled\\src\\workTestMianshi\\XMlDomSex\\test.xml");
            NodeList sList= d.getElementsByTagName("student");
            //element(sList);
            node(sList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * @Author: cxx
 * SAX解析DOM
 * 一行一行  Handler
 * startElement
 * endElement
 * @Date: 2018/5/29 20:03
 */
 class SaxDemo {

    public static void main(String[] args) throws Exception {
        //1.或去SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.获取SAXparser实例
        SAXParser saxParser = factory.newSAXParser();
        //创建Handel对象
        SAXDemoHandel handel = new SAXDemoHandel();
        saxParser.parse("src/main/resources/demo.xml",handel);
    }
}

class SAXDemoHandel extends DefaultHandler {
    //遍历xml文件开始标签
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始");
    }

    //遍历xml文件结束标签
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")){
            System.out.println("============开始遍历student=============");
            //System.out.println(attributes.getValue("rollno"));
        }
        else if (!qName.equals("student")&&!qName.equals("class")){
            System.out.print("节点名称:"+qName+"----");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student")){
            System.out.println(qName+"遍历结束");
            System.out.println("============结束遍历student=============");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch,start,length).trim();
        if (!value.equals("")) {
            System.out.println(value);
        }
    }
}

/**
 * @Author: cxx
 * Dom4j解析xml
 * @Date: 2018/5/30 12:21
 */
/*
class Dom4JDemo {
    public static void main(String[] args) throws Exception {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = reader.read(new File("src/main/resources/demo.xml"));
        //3.获取根节点
        Element rootElement = ((org.dom4j.Document) document).getRootElement();
        Iterator iterator = ((org.dom4j.Element) rootElement).elementIterator();
        while (iterator.hasNext()){
            Element stu = (Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()){
                Element stuChild = (Element) iterator1.next();
                System.out.println("节点名："+stuChild.getName()+"---节点值："+stuChild.getStringValue());
            }
        }
    }
}*/
