package club.gongsir.pojo;

import java.io.Serializable;

/**
 * @author 龚涛
 * 系统管理员
 */
public class Admin implements Serializable {
    //主键id
    private Integer id;
    //管理员账号
    private String count;
    //管理员密码
    private String password;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", count='" + count + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}