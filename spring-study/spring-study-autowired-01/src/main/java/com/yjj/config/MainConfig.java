package com.yjj.config;

import com.yjj.bean.BookDao;
import com.yjj.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/26 17:42
 * @Version: 1.0
 */
@Configuration
@ComponentScan(value = "com.yjj")
public class MainConfig {

    /**
     * 自动装配：
     *      Spring利用依赖注入（DI），完成对IOC容器中各个组件依赖关系的赋值
     *  1.@Autowired 自动注入
     *      1）默认优先按照类型去容器中找相应的组件，找到则赋值 applicationContext.getBean(BookService.class);
     *      2）如果找到多个相同类型的组件，再将属性的名称作为组件名去容器中查找 applicationContext.getBean("bookService");
     *      3) @Qualifier(value = "bookDao") 使用@Qualifier指定需要装配的组件的id，而不是使用属性名
     *      4）自动装配默认一定要将属性赋值好，如果找不到就会报错
     *      5）@Primary:让Spring进行自动装配的时候，默认使用首选的bean
     *         也可以继续使用@Qualifier指定需要装配的bean
     *  2.Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[Java规范的注解]
     *      1）@Resource:
     *          可以和@Autowired一样实现自动装配的功能；默认是按照组件名称进行装配的；
     *          没有能支持@Qualifier和@Primary和@Autowired(required=false)功能
     *      3）@Inject：
     *          需要导入javax.inject包，和Autowired功能一样，也能支持primary，但是没有required属性
     *
     *  总结：@Autowired：Spring定义的；@Resource、@Inject都是java规范
     *  AutowiredAnnotationBeanPostProcessor 后置处理器就是处理自动注入这些注解的
     *
     *  3.@Autowired：可放在属性上、方法上、构造器上、已经参数上
     *  4.自定义组件如果想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory...等）可以实现xxxAware接口
     *    在创建对象的时候，会调用接口规定的方法进行注入赋值
     *    xxxAware功能基本都是通过后置处理器xxxProcessor来实现的
     *    ApplicationContextAware是通过ApplicationContextAwareProcessor来实现的
     *    BeanFactoryAware是通过
     *
     */
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(Car car){
        BookDao bookDao=new BookDao();
        bookDao.setLable("2");
        bookDao.setCar(car);
        return bookDao;
    }
}
