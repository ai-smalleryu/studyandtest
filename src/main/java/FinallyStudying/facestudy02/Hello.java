package FinallyStudying.facestudy02;

class A {
    static {
        System.out.println("1");
    }

    public A() {
        System.out.println("2");
    }
}

class B extends A {
    static {
        System.out.println("a");
    }

    public B() {
        System.out.println("b");
    }
}

public class Hello {
    static {
        System.out.println("hello 静态代码块");
    }

    {
        System.out.println("hello 代码块");
    }

    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}
/*

    public void saveAuthority(User user) {
        String str = user.getUserName();
        String[] arrayStr = str.split(",");
        int id = user.getId();
        User user2 = userDAO.findUserByPrimaryKey(id);
        Set<Authority> authorities = authorityDAO.findAllAuthoritys();
        Set<Authority> sets = user.getAuthorities();
        for (int i = 0; i < arrayStr.length; i++) {
            String auth = arrayStr[i];
            int authorityId = Integer.parseInt(auth);
            for (Authority authority : authorities) {
                if (authority.getId() == authorityId) {
                    sets.add(authority);
                }
            }
            user2.setAuthorities(sets);
            userDAO.store(user2);
            userDAO.flush();
        }

    }
*/

/*
package com.candy.hibernate.bean;
        import java.io.Serializable;
        import java.util.LinkedHashSet;
        import java.util.Set;
        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.FetchType;
        import javax.persistence.Id;
        import javax.persistence.ManyToMany;
        import javax.persistence.Table;
@Entity
@Table(name="user")
 class User implements Serializable {
    */
/**
     *
     *//*

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="user_id", length=7, nullable=false)
    private String id;

    @Column(name="user_name", length=20,nullable=false)
    private String name;

    @Column(name="user_pwd",length=20,nullable=false)
    private String password;

    @Column(name="user_addr",length=50)
    private String address;

    @Column(name="user_mail" ,length=20)
    private String email;
    @Column(name="head_img" ,length=50)
    private String headImage;

    @ManyToMany(mappedBy="users", fetch=FetchType.LAZY)
    private Set<Role> roles = new LinkedHashSet<Role>();


@Entity
@Table(name="role")
public class Role implements Serializable {
    */
/**
     *
     *//*

    private static final long serialVersionUID = 1597271124780386657L;
    @Id
    @Column(name="role_id",length=7,nullable=false)
    private int id;

    @Column(name="role_name",length=10, nullable=false)
    private String role;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name="user_role",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="user_id")})
    private Set<User> users = new LinkedHashSet<User>();

    @ManyToMany(mappedBy="roles")
    private Set<Priority> prioritys = new LinkedHashSet<Priority>();

} */
