package com.yjj.bean;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 15:58
 * @Version: 1.0
 */
public class Car {
    public Car() {
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car init方法...");
    }

    public void destroy(){
        System.out.println("car destroy方法...");
    }
}
