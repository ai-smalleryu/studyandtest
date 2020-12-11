package StuTes;

public class DependencIn {
    public static void main(String[] args) {

    }
}
class email{
    public String getInfo()
    {
        return "电子邮件";
    }
}
//接收消息的功能
/*
Person 依赖Email
 */
class  Person
{
    public  void receive(email e){
        System.out.println(e.getInfo());
    }
}
