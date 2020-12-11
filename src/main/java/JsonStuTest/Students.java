package JsonStuTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Administrator
 * @PACKAGE_NAME: JsonStuTest
 * @PROJECT_NAME: studyandtest
 * @DESCRIPTION:
 * @USER: Administrator
 * @DATE: 2020/10/28 17:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students implements Serializable {
    private String name;
    private int age;
}
