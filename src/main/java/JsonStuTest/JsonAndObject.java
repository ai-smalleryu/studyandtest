package JsonStuTest;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author Administrator
 * @PACKAGE_NAME: JsonStuTest
 * @PROJECT_NAME: studyandtest
 * @DESCRIPTION:
 * @USER: Administrator
 * @DATE: 2020/10/28 17:20
 */
public class JsonAndObject {
    public static void main(String[] args) {
        Students tom = new Students("tom", 12);
        Object o = JSONObject.toJSON(tom);
        System.out.println(o);

    }
}
