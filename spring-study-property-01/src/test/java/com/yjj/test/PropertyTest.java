package com.yjj.test;


import com.yjj.bean.Person;
import com.yjj.conf.PropertyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 16:01
 * @Version: 1.0
 */
public class PropertyTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(PropertyConfig.class);
        System.out.println("容器创建完成");
        Person person=applicationContext.getBean(Person.class);
        System.out.println(person);
        ConfigurableEnvironment environment=applicationContext.getEnvironment();
        String gender=environment.getProperty("person.gender");
        System.out.println(gender);
        //关闭容器 容器中所有bean将销毁
        applicationContext.close();
    }
}
