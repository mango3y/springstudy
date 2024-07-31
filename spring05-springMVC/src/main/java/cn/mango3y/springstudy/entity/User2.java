package cn.mango3y.springstudy.entity;

import cn.mango3y.springstudy.serialize.MySerializer2;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.util.Date;

@Data
public class User2 {
    @JSONField(serialize = false) //当前属性不显示在json中
    private Integer id;
    @JSONField(name="NAME", serialzeFeatures = SerializerFeature.WriteNullStringAsEmpty) //改变name属性的json名，且当该值为空，输出""
    private String name;
    @JSONField(serialzeFeatures = SerializerFeature.WriteMapNullValue) //为空时输出null
    private String city;
    @JSONField(format="yyyy/MM/dd HH:mm:ss")
    private Date birth;
    @JSONField(serializeUsing = MySerializer2.class) //定制序列化
    private Double salary;

    public User2() {
    }

    public User2(Integer id, String name, String city, Date birth, Double salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.birth = birth;
        this.salary = salary;
    }
}
