package com.yjj.test;

import com.yjj.aop.MathCalculator;
import com.yjj.config.AopConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/28 17:17
 * @Version: 1.0
 */
public class AopTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AopConfig.class);
        //要从容器中获取对象，不能只new对象，如果是自己new的对象则切面无效
        MathCalculator mathCalculator=applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(2, 1);
    }
}
