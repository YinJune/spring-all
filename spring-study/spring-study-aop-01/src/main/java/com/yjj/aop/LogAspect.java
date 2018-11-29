package com.yjj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/28 16:09
 * @Version: 1.0
 */
//告诉Spring当前类是一个切面类
@Aspect
public class LogAspect {

    //抽取公共的切入点表达式
    @Pointcut("execution(public int com.yjj.aop.MathCalculator.*(..))")
    public void pointCut(){}

    /**
     * @Before 在目标方法之前切入；切入点表达式（指定在哪个方法切入）
     * public int com.yjj.aop.MathCalculator.div(int,int)
     * public int com.yjj.aop.MathCalculator.*(int,int)
     * public int com.yjj.aop.MathCalculator.*(..)
     */
    /**
     * JoinPoint 一定要出现在参数表的第一位！！！
     * @param joinPoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。@Before参数列表是："+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"运行结束。。@After");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"法正常返回。。@AfterReturning运算结果是：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing ="e")
    public void logException(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+"运行异常。。@AfterThrowing异常信息：{"+e.getMessage()+"}");
    }
}
