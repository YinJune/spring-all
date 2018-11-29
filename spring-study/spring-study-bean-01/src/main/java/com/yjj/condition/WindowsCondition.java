package com.yjj.condition;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/22 14:30
 * @Version: 1.0
 */
public class WindowsCondition implements Condition{
    /**
     *
     * @param conditionContext 判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //能获取到IOC使用的beanFactory
        ConfigurableBeanFactory beanFactory=conditionContext.getBeanFactory();
        //能获取到类加载器
        ClassLoader classLoader=conditionContext.getClassLoader();
        //当前环境信息
        Environment environment=conditionContext.getEnvironment();
        //获取到bean定义的注册类
        BeanDefinitionRegistry registry=conditionContext.getRegistry();
        //容器中是否包含某一个bean，也可以给容器中注册bean
        boolean definition=registry.containsBeanDefinition("person");
        String osName=environment.getProperty("os.name");
        if (osName.contains("Windows")){
            return true;
        }
        return false;
    }
}
