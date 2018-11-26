package com.yjj.conf;

import com.yjj.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 15:57
 * @Version: 1.0
 */
@Configuration
@ComponentScan(value = "com.yjj.bean")
public class LifeCycleConfig {

    /**
     * bean的生命周期：
     *      创建--初始化--销毁
     * 容器管理bean的声明周期，我们可以自定义bean的初始化和销毁方法
     * 1.指定init-method和destroy-method
     *      初始化：
     *          对象创建完成，并赋值好，进行bean初始化
     *      销毁：
     *          单实例：容器关闭时进行销毁
     *          多实例：容器才不管你，你自己爱啥时候销毁啥时销毁
     * 2.通过让Bean实现InitializingBean（定义初始化逻辑）DisposableBean（定义销毁逻辑）
     * 3.使用JSR250注解：
     *      @PostConstruct：在bean创建完成并且赋值完成之后，执行初始化方法
     *      @PreDestroy 容器销毁之前调用
     * 4.BeanPostProcessor：bean后置处理器
     *      在bean初始化前后进行一些处理工作，实现接口的两个方法
     *      postProcessBeforeInitialization：初始化(上边1.2.3方法)之前工作
     *      postProcessAfterInitialization：初始化(上边1.2.3方法)之后工作
     *
     */

//    @Scope(value = "prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
