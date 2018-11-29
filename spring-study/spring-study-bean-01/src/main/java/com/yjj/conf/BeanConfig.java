package com.yjj.conf;

import com.yjj.bean.Person;
import com.yjj.dao.BookDao;
import com.yjj.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Description: 单个注册以及包扫描
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 14:06
 * @Version: 1.0
 */
@Configuration //告诉Spring这是一个配置类 相当于以前的.xml配置文件
@ComponentScan(value = "com.yjj",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
                Controller.class,
        }),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDao.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//@ComponentScan(value = "com.yjj",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
//                Controller.class,
//                Service.class
//        })
//})
public class BeanConfig {

    /**
     * 注：@ComponentScan
     *  value：指定要扫描的包
     *  excludeFilters = 按照设置的规则排除bean
     *  includeFilters = Filter[] 只包含 首先要设置默认过滤规则为false
     */

    /**
     * 向容器中注册一个bean；类型为返回值的类型，
     * 写一个方法返回一个person对象即可 bean的id默认为方法名
     * 可指定Bean注解的name或value属性值指定bean的名称
     * @return
     */
    @Bean(value = "person") //相当于.xml中的<bean></bean>标签
    public Person getPerson(){
        return new Person("张三",18);
    }
}
