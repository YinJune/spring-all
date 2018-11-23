package com.yjj.conf;

import com.yjj.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Description: 懒加载
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 16:53
 * @Version: 1.0
 */
@Configuration
public class BeanConfig2 {

    /**
     * prototype：多实例，IOC容器启动并不会去调用方法创建对象放在容器中
     *            每次获取的时候才会调用方法创建对象，每获取一次，都会创建一个对象
     * singleton：单实例（默认），IOC容器启动时就会创建对象放入容器中，
     *            以后每次获取都是从容器中直接拿（map.get()）
     * request: 同一次请求创建一个实例
     * session：同一个session创建一个实例
     * @return
     */
//    @Scope("prototype")
    @Lazy
    @Bean(value = "person")
    public Person person(){
        System.out.println("创建person对象");
        return new Person("李四",20);
    }
}
