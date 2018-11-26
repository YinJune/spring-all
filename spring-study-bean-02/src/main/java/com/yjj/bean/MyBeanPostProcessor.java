package com.yjj.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description: 后置处理器：初始化前后进行处理工作
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 17:00
 * @Version: 1.0
 */
//将后置处理器加入到容器中才能工作
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 初始化之前
     * @param bean bean对象
     * @param beanName bean的名字
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"初始化前工作...");
        return bean;
    }

    /**
     * 初始化之后
     * @param bean
     * @param beanName
     * @return 可以返回原始对象，也可返回包装后的bean对象
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"初始化后工作...");
        return bean;
    }
}
