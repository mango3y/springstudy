package cn.mango3y.springstudy.spring01.entity;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private Integer id;
    private String password;
    private String sex;
    private Integer age;
    private Date bornDate;
    private String[] hobbys;
    private Set<String> phones;
    private List<String> names;
    private Map<String,String> countries;
    private Properties files;
    private Address address;
    private Address[] addresses;
    private List<Address> addressList;
}
