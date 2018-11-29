package com.yjj.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/27 17:54
 * @Version: 1.0
 */
@Component
public class MyComponent implements ApplicationContextAware, BeanNameAware,EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println(applicationContext);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前bean的名字为："+s);
    }

    /**
     * 解析器用来解析。。这种字符串带表达式的，额，，你懂的吧
     * @param stringValueResolver
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String result=stringValueResolver.resolveStringValue("你好，${os.name},我是#{20*18}");
        System.out.printf("解析结果为%s\n",result);
    }
}
