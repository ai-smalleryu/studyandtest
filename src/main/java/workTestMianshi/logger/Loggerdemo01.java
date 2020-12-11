package workTestMianshi.logger;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.*;

public class Loggerdemo01 {
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setLevel(Level.FINE);
        Logger global = Logger.getGlobal();
        global.setLevel(Level.FINE);
        global.addHandler(fileHandler);
        global.info("asa");
        global.fine("asa");
        //apachLog();

    }
    @Test
    public void logger(){
        Logger global = Logger.getGlobal();
        global.info("aaaaaaaaaaaaaaaaaaaaaa");
        global.severe("aaaaaaaaaaaaaaa");
        Logger global1 = Logger.getGlobal();
        global1.info("aaaasssss");
        global1.info("ssssssssssssssssss");
        Logger los = Logger.getLogger("los");
        los.info("aaaaaaaaaaaaassssssssssssssssssssssss");
    }
    @Test
    public void handerTest(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        Logger global = Logger.getGlobal();
        global.setLevel(Level.FINE);
        global.addHandler(consoleHandler);
        global.fine("可以打印");

        Logger global1 = Logger.getGlobal();
        global1.fine("buke");
    }
    @Test
    public void handerTest2(){
        Logger global = Logger.getGlobal();
        global.setLevel(Level.FINE);
        global.fine("可以打印");
        Logger global1 = Logger.getGlobal();
        global1.fine("buke");
    }
    @Test
    public void filtertest(){
        Logger global = Logger.getGlobal();
        global.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                if(record.getMessage().contains("as"))//record获得信息后是否包含字母a
                    return false;//如果方法返回false则不记录
                else
                    return true;
            }
        });
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        global.setLevel(Level.FINE);
        global.addHandler(consoleHandler);
        global.info("jaazszsaxsdddd");//不记录
        global.fine("aaaaaaaaaaaaaaaaaa");//记录信息
    }
    @Test
    public void concat(){
        String as = new String("as");
        String aaa = as.concat("aaa");
        System.out.println(aaa.hashCode()+"aaa"+as.hashCode());
        as="aaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(as.hashCode());
    }

    @Test
    public void format() throws IOException {
        Formatter formatter = new Formatter() {//格式化器日志规定格式信息
            @Override
            public String format(LogRecord record)  {
                return LocalDateTime.now() + ": " +record.getMessage() + "\n";
            }
        };

        Handler fileHandler = new FileHandler();
        fileHandler.setLevel(Level.INFO);
        fileHandler.setFormatter(formatter);

        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINER);
        consoleHandler.setFormatter(formatter);


        Logger logger = Logger.getGlobal();
        logger.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                //如果方法返回false，则该条日志不被记录。
                if (record.getMessage().contains("a"))
                    return false;
                else
                    return true;
            }
        });

        logger.setLevel(Level.FINER);
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);
        logger.info("bbbb.....");
        logger.fine("sdf.....");
    }
    @Test
    public void filterHander() throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFormatter(new Formatter(){

            @Override
            public String format(LogRecord record) {
                return LocalDateTime.now()+"shijian"+record.getMessage();
            }
        });
        fileHandler.setLevel(Level.FINE);
        Logger logger =  Logger.getGlobal();
        logger.setLevel(Level.FINE);
        logger.addHandler(fileHandler);
        logger.info("aaaaa");
        logger.fine("sssx");
    }
    @Test
    public void conHander() throws IOException {
        ConsoleHandler fileHandler = new ConsoleHandler();
        fileHandler.setLevel(Level.FINE);
        Logger logger =  Logger.getGlobal();
        logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.info("aaaaa");
        logger.fine("sssx");
    }

}
