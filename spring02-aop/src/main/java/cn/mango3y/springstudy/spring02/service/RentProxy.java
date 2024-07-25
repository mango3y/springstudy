package cn.mango3y.springstudy.spring02.service;

import lombok.Setter;

//静态代理类：明确写出的代理类？？？
//房东将租房的辅助功能交由代理类处理
//则代理类中只能出现租房相关的辅助功能，而不要做多余的事
//比如说房东只是要你租房，你别把房卖了
//为了达到这个目的，要求代理类和业务类实现相同的接口
public class RentProxy implements RentService{

    private RentService rentService = new RentServiceImpl();

    @Override
    public void rent() {
        //帮房东做的辅助功能
        System.out.println("发布租房信息");
        System.out.println("带租客看房");
        //核心功能应还给业务类，此处要调用业务类，则本类要持有原始业务类的引用
        rentService.rent();
    }
}
