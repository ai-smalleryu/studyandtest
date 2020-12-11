package MybatisTestDay2;

import java.sql.Date;
import java.util.Arrays;

public class SysUser {
    private int id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] userImg;
    private Date createTime;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", userImg=" + Arrays.toString(userImg) +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public byte[] getUserImg() {
        return userImg;
    }

    public void setUserImg(byte[] userImg) {
        this.userImg = userImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysUser() {
    }

    public SysUser(int id, String userName, String userPassword, String userEmail, String userInfo, byte[] userImg, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userInfo = userInfo;
        this.userImg = userImg;
        this.createTime = createTime;
    }
    public SysUser(int id, String userName, String userPassword, String userEmail, String userInfo, byte[] userImg) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userInfo = userInfo;
        this.userImg = userImg;
    }
}
