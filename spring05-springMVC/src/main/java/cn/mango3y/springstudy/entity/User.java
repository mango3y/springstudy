package cn.mango3y.springstudy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//如果不是中国时间，请加上时区
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;

    private Boolean gender;

    public User() {}

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }
}
