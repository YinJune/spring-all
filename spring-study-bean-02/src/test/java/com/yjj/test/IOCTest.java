package com.yjj.test;

import com.yjj.bean.Car;
import com.yjj.conf.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 16:01
 * @Version: 1.0
 */
public class IOCTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成");
        Car car= (Car) applicationContext.getBean("car");
        //关闭容器 容器中所有bean将销毁
        applicationContext.close();
    }
}
