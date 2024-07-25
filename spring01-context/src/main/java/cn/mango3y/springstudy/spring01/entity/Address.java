package cn.mango3y.springstudy.spring01.entity;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class Address {
    private Integer id;
    private String city;

    public Address() {
        System.out.println("Address无参构造");
    }

    public void setId(Integer id) {
        System.out.println("Address-setId");
        this.id = id;
    }

    public void setCity(String city) {
        System.out.println("Address-setCity");
        this.city = city;
    }

    //如果在spring-context的bean中指定了对应的init-method和destroy-method，不加@PostConstruct和@PreDestroy两个注解也可以
    //因为我测试过了，删掉spring-context的init-method和destroy-method属性，则init_address和destroy_address
    //那好像这两个注解加不加都无所谓……
    @PostConstruct
    public void init_address(){
        System.out.println("Address初始化");
    }

    @PreDestroy
    public void destroy_address(){
        System.out.println("Address销毁");
    }
}
