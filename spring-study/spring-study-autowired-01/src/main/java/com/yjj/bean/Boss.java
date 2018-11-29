package com.yjj.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/27 14:57
 * @Version: 1.0
 */
@Component
public class Boss {
    private Car car;

    //Spring容器初始化组件时默认调用对象的无参构造器，我们只给一个有参的构造器
    //并在构造器上标注@Autowired注解 此时参数对象会从Spring容器中获取
    //当只有一个有参构造器时，@Autowired可省略
    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }

//    @Autowired
    //标注在方法上，Spring创建当前对象，就会调用方法进行赋值
    //方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
