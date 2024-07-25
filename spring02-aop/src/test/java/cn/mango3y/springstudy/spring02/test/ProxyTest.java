package cn.mango3y.springstudy.spring02.test;

import cn.mango3y.springstudy.spring02.service.RentProxy;

public class ProxyTest {
    @org.junit.Test
    public void test01(){
        RentProxy rentProxy = new RentProxy();
        rentProxy.rent();
    }
}
