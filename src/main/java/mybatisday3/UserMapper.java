package mybatisday3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectUserId(int id);
    List<User> getUserlikename(String str);
    List<User> getUserByMap(HashMap<Object, Object> map);
    int deleteId(int id);

}
