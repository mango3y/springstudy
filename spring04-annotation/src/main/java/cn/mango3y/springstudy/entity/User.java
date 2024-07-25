package cn.mango3y.springstudy.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Boolean gender;
    //1.如果属性registerTime则该项为空
    //private Date register_time;

    //2.解决方式: 在MyBatis的Mapper XML文件中定义<resultMap>
    private Date registerTime;

    public User() {
    }

    public User(Integer id, String username, String password, Boolean gender, Date registerTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.registerTime = registerTime;
    }
}
