package com.yjj.conf;

import com.yjj.bean.Person;
import com.yjj.condition.LinuxCondition;
import com.yjj.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Description: 条件注册@Conditional
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 16:53
 * @Version: 1.0
 */
@Configuration
public class BeanConfig3 {

    /**
     * @Conditional: 按照一定条件进行判断，满足条件给容器中注册bean
     *               需要一个Condition数组
     *               放在类上面时，该类配置的所有bean注册才能生效
     */
    @Conditional({WindowsCondition.class})
    @Bean(value = "Bill")
    public Person person01(){
        return new Person("Bill",20);
    }

    @Conditional({LinuxCondition.class})
    @Bean(value = "Linus")
    public Person person02(){
        return new Person("Linus",20);
    }


}
