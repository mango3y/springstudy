package cn.mango3y.springstudy.spring02.service;

//原始业务类
public class RentServiceImpl implements RentService{
    @Override
    public void rent() {
        //辅助功能，后面应交由代理处理
//        System.out.println("发布租房信息");
//        System.out.println("带租客看房");

        //核心功能
        System.out.println("签合同");
        System.out.println("收房租");
    }
}
