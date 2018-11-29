package com.yjj;

import com.yjj.bean.Person;
import com.yjj.conf.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 14:09
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
        Person person= (Person) context.getBean(Person.class);
        String[] beanNames= context.getBeanNamesForType(Person.class);
        System.out.println(person);
        for (String name:beanNames){
            System.out.println(name);
        }
    }
}
