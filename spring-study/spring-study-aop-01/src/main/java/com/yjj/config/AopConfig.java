package com.yjj.config;

import com.yjj.aop.LogAspect;
import com.yjj.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/28 16:03
 * @Version: 1.0
 */
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
    /**
     * AOP：[动态代理]
     *      在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
     *
     * 1.导入aop模块(spring-aspects)
     * 2.定义业务逻辑类MathCalculator,在业务逻辑运行的时候讲日志打印（方法运行之前，之后，异常时）
     * 3.定义日志切面类LogAspect，切面类里面的方法需要动态感知业务逻辑类运行到哪然后执行
     *      通知方法：
     *          前置通知(@Before)：logStart 在目标方法(div)运行之前运行
     *          后置通知(@After)：logEnd 在目标方法(div)运行结束之后运行
     *          返回通知(@AfterReturning)：logReturn 在目标方法(div)正常返回之后运行
     *          异常通知(@AfterThrowing)：logException 在目标方法(div)出现异常以后运行
     *          环绕通知(@Around)：动态代理，手动推进目标方法运行
     * 4.给切面类的目标方法标注何时何地运行（通知注解）
     * 5.将切面类和业务逻辑类（目标方法所在类）都加入到容器中
     * 6.必须告诉Spring哪个类是切面类（给切面类加注解@Aspect）
     * 7.给配置类加@EnableAspectJAutoProxy 开启基于注解的aop模式
     *      在Spring中有很多的@Enablexxx；都是用来开启什么功能
     *
     *  三步：
     *      1）将业务逻辑和切面类加入到容器中，告诉Spring哪个是切面类（@Aspect）
     *      2）在切面类上每一个方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
     *      3）开启基于注解的AOP模式
     *
     * -----------------------------------------------------------------------------------------
     * AOP原理：
     *      看给容器中注册了什么组件，这个组件什么时候工作，组件的功能是什么？
     * 1.@EnableAspectJAutoProxy是什么，做了什么
     *      通过@Import(AspectJAutoProxyRegistrar.class)给容器中初始化注入了AnnotationAwareAspectJAutoProxyCreator组件
     *      利用AspectJAutoProxyRegistrar给容器注入bean；
     * 2.AnnotationAwareAspectJAutoProxyCreator
     *      ->AspectJAwareAdvisorAutoProxyCreator
     *          ->AbstractAdvisorAutoProxyCreator
     *              ->AbstractAutoProxyCreator extends ProxyProcessorSupport implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
     *                  ->实现了后置处理器，又实现了BeanFactoryAware
     *
     *
     */

    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
