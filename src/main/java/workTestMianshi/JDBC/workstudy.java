package workTestMianshi.JDBC;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class workstudy {
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
    /*    conten();
        data();*/
        //testTxt();
        //jdbc();
        insetData();
    }
    //测试
    private static void testTxt() {
        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")))) {
            List<String[]> list = new CopyOnWriteArrayList<>();
            String[] strings = null;
            String s = "";
            while ((s = read.readLine()) != null) {
                //循环读取数据
                System.out.println(s + "=============");
                strings = s.split("[|]");
                System.out.println(strings[0] + "zzzzzzzzzzzzzzzzzzzzzzzzzz" + strings[2]);
                list.add(strings);
            }
            System.out.println(list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //测试
    public static synchronized void jdbc() throws ClassNotFoundException, ParseException {
        List<Studentjdbc> list = getauther();
/*for (int i=0;i<list.size();i++){
    String[] strings = list.get(i);
    System.out.println(strings.toString());
    String string = strings[2];
    System.out.println(string);
   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date parse = simpleDateFormat.parse(string);
    System.out.println(parse);
    System.out.println(simpleDateFormat.format(parse));
}*/


        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name = "root";//密码
        String password = "root";
        Class.forName(driver);
        // String sql = "insert into worktest (id, name, birthday, sex) values (?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, name, password)) {
            // PreparedStatement statement = con.prepareStatement(sql);
            Statement statement = con.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //  con.setAutoCommit(false);
            for (int i = 0; i < list.size(); i++) {
          /*      String[] strings = list.get(i);
                int id = Integer.parseInt(strings[0]);
                String na = strings[1];
                Date date = simpleDateFormat.parse(strings[2]);
                java.sql.Date date1 = new java.sql.Date(date.getTime());
                char c = strings[3].charAt(0);
                //System.out.println(na.length());
                int count = 0;
                    count++;

                System.out.println(count);*/
                //   System.out.println(id+"姓名"+na+"时间"+simpleDateFormat.format(date)+"xingb"+c);
           /*     Te t;
                if (c.equals("M")) {
                    t = Te.M;
                } else {
                    t = Te.F;

                }*/

              /*  statement.setInt(1, id);
                statement.setString(2, na);
                statement.setDate(3, date1);
                statement.setString(4, c);*/
          /*    if (count<1000){
              statement.executeUpdate("insert into sumtestwork (id, name, birthday, sex) values (" + id + "," + na + "," + date1 + "," + c + ")");
              }
              if (count>1000)break;*/
                // statement.addBatch("insert into sumtestwork (id, name, birthday, sex) values (" + id + "," + na + "," + date1 + "," + c + ")");
                //statement.addBatch("insert into testnews (id, name, birthday, sex) values (" + id + "," + na + "," + strings[2] + "," + strings[3] + ")");
            }

            //int[] counts = statement.executeBatch();
            //  con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //存储到数据库
    public static synchronized void insetData() throws ClassNotFoundException {
        List<Studentjdbc> studentjdbcList = getauther();
        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name = "root";//密码
        String password = "root";
        Class.forName(driver);
        String sql = "insert into studentjdbc2 (id, name, birthday, sex) values (?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, name, password);
             PreparedStatement p = con.prepareStatement(sql)) {
            con.setAutoCommit(false);
            for (int i = 0; i < studentjdbcList.size(); i++) {
                Studentjdbc studentjdbc = studentjdbcList.get(i);
                p.setInt(1, studentjdbc.getId());
                p.setString(2, studentjdbc.getName());
                p.setDate(3, studentjdbc.getDate());
                p.setString(4, studentjdbc.getTe());
                p.addBatch();
            }
            int[] ints = p.executeBatch();
            System.out.println(ints.length);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //文档读取数据
    private static synchronized List<Studentjdbc> getauther() {
        List<Studentjdbc> list = new CopyOnWriteArrayList<>();
        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")))) {
            String[] strings = null;
            String s = "";
            Studentjdbc studentjdbc = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while ((s = read.readLine()) != null) {
                //循环读取数据
                // System.out.println(s+"=============");
                studentjdbc = new Studentjdbc();
                strings = s.split("[|]");
                //System.out.println("用户id" + strings[0] + "用户名称" + strings[1] + "时间" + strings[2] + "性别" + strings[3]);
                studentjdbc.setId(Integer.parseInt(strings[0]));
                studentjdbc.setName(strings[1]);
                Date parse = simpleDateFormat.parse(strings[2]);
                java.sql.Date date1 = new java.sql.Date(parse.getTime());
                studentjdbc.setDate(date1);
                studentjdbc.setTe(strings[3]);
                list.add(studentjdbc);
            }
            //System.out.println(list.size());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static synchronized Te sex() {
        Random random = new Random();
        int i = random.nextInt(2) + 1;
        if (i == 1) {
            return Te.F;
        } else {
            return Te.M;
        }
    }

    //写入文档
    private static synchronized void conten() throws IOException {
        try (Reader read = new FileReader("a.txt");
             Writer writer = new FileWriter("a.txt", false)
        ) {
            for (int i = 1; i <= 10000; i++) {
                writer.write(i + "|" + name() + "|" + data() + "|" + sex() + "\n");
            }
            writer.flush();
        }
    }

    //获取姓名
    private static synchronized String name() {
        Random rand = new Random();//nextInt()不是静态方法，不能直接用类名调用
        int i = rand.nextInt(4) + 3;
        String s = "qwertyuioplkjhgfdsazxcvbnm";
        char[] chars = s.toCharArray();
        int length = chars.length;
        String s1 = "";
        for (int j = 0; j < i; j++) {
            Random random = new Random();
            int i1 = rand.nextInt(26);
            char x = chars[i1];
            s1 += x;
        }
        return s1;
    }

    //获取时间
    private static synchronized String data() {

        Date randomDate = randomDate("1990-01-01", "2222-03-31");
        //  System.out.println(randomDate.toString());
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println();

        return s.format(randomDate);
    }

    private static synchronized Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            //获取毫秒数
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static synchronized long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

}

enum Te {
    M, F
}

class Studentjdbc {
    private int id;
    private String name;
    private java.sql.Date date;
    private String te;

    @Override
    public String toString() {
        return "author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", te=" + te +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }
}

