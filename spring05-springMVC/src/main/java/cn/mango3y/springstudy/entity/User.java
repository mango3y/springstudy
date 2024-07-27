package cn.mango3y.springstudy.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private Boolean gender;
}
