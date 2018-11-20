package com.yjj.test;

import com.yjj.bean.Person;
import com.yjj.conf.BeanConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 14:19
 * @Version: 1.0
 */
public class IOCTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanConfig2.class);
        System.out.println("IOC容器启动完成");
        Person person1= (Person) applicationContext.getBean("person");
        Person person2= (Person) applicationContext.getBean("person");
        System.out.println(person1==person2);
    }
}
