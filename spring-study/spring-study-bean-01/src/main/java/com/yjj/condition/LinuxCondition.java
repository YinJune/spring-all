package com.yjj.condition;

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
public class LinuxCondition implements Condition{

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //当前环境信息
        Environment environment=conditionContext.getEnvironment();
        String osName=environment.getProperty("os.name");
        if (osName.contains("Linux")){
            return true;
        }
        return false;
    }
}
