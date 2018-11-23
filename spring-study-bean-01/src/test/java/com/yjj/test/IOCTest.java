package com.yjj.test;

import com.yjj.bean.Person;
import com.yjj.conf.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 14:19
 * @Version: 1.0
 */
public class IOCTest {

    public void printBeansByType(ApplicationContext applicationContext,Class clazz){
        String[] beanNames=applicationContext.getBeanNamesForType(clazz);
        for (String name:beanNames){
            System.out.println(name);
        }
    }
    public void printBeans(ApplicationContext applicationContext){
        String[] beanNames=applicationContext.getBeanDefinitionNames();
        for (String name:beanNames){
            System.out.println(name);
        }
    }

    /**
     * 懒加载
     */
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println("IOC容器启动完成");
        Person person1= (Person) applicationContext.getBean("person");
        Person person2= (Person) applicationContext.getBean("person");
        System.out.println(person1==person2);
    }

    /**
     * 条件注册
     */
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanConfig2.class);
        ConfigurableEnvironment environment=applicationContext.getEnvironment();
        String osName=environment.getProperty("os.name");
        System.out.println(osName);

        Map<String,Person> personMap=applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    /**
     * 导入组件
     */
    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanConfig4.class);
        printBeans(applicationContext);
        //获取的其实是工厂对象返回的对象
        Object bean=applicationContext.getBean("colorFactoryBean");
        Object bean2=applicationContext.getBean("colorFactoryBean");
        System.out.println("colorFactoryBean的类型："+bean.getClass());
        System.out.println("colorFactoryBean是单实例的吗？"+bean==bean2);
        //如果就想获取ColorFactoryBean对象怎么办呢
        Object colorFactoryBean=applicationContext.getBean("&colorFactoryBean");
    }
}
