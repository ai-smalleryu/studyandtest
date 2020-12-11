package ImpLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Administrator
 * @PACKAGE_NAME: ImpLambda
 * @PROJECT_NAME: studyandtest
 * @DESCRIPTION:
 * @USER: Administrator
 * @DATE: 2020/11/23 9:31
 */
public class LmplambdaFind {
    public static void main(String[] args) {
        List<String > stringList=new ArrayList<>();
        stringList.add("a");
        stringList.add("as");
        stringList.add("cx");
        stringList.add("dedsad");
        stringList.add("dsad");
        stringList.add("sad");
        Optional<String> first = stringList.stream().findFirst();
        if (first.isPresent()){
            System.out.println(first.get());
        }
    }
}
