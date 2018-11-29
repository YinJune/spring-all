package com.yjj.selector;

import com.yjj.importBean.Green;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/22 18:03
 * @Version: 1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 把所有需要添加到容器的bean通过beanDefinitionRegistry的registerBeanDefinition
     * @param annotationMetadata 当前类注解信息
     * @param beanDefinitionRegistry DefinitionRegistry注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition=beanDefinitionRegistry.containsBeanDefinition("com.yjj.bean.Red");
        boolean definition2=beanDefinitionRegistry.containsBeanDefinition("com.yjj.bean.Yellow");
        if (definition&&definition2){
            RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(Green.class);
            //第一个参数为bean的名称，第二个rootBeanDefinition
            beanDefinitionRegistry.registerBeanDefinition("green啊啊啊", rootBeanDefinition);
        }
    }
}
