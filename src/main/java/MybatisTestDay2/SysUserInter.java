package MybatisTestDay2;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
public interface SysUserInter {

    public void selectUnionId(int id);
    //map返回key就是列名值就是对应的值
    public  List<SysUser> getSysUserByLikeName(String lastName);
    public SysUser getSaysUsersId(int id);
    public SysUser getSaysUsersList(List<Object> list);
    public SysUser getSaysUsersIdMap(Map<String, Object> map);
    public SysUser getSaysUsersIdMapdoller(Map<String, Object> map);
    public SysUser getSaysUsersAll(int id);
    public SysUser getSaysUsersIdmore2(@Param("id") int id, @Param("password") String password);
    public SysUser getSaysUsersIdmore(int id, String password);
    public  void  addSysUser(SysUser sysUser);
    public void updateSysUser(SysUser sysUser);
    public void deleteSysUser(Integer id);
    public Map<String , Object> getUserMap(int id);
    //多条记录封装成一个map 数据库主键作为map集合的Key 信息作为Values 此时使用注解的形式    [如果是用name作为key也是注解的形式]
    @MapKey("id")
    public  Map<Integer,SysUser> getByIdMap(int id);


}
