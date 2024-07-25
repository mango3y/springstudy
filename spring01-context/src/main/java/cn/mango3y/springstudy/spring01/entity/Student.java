package cn.mango3y.springstudy.spring01.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
