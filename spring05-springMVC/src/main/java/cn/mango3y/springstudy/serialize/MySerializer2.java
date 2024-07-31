package cn.mango3y.springstudy.serialize;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class MySerializer2 implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        Double value = (Double) o; //salary属性值
        String number = BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
        String numberWithUnit = number + "元"; //在salary后面拼接元
        jsonSerializer.write(numberWithUnit);
    }
}
