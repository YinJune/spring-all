package com.yjj.conf;

import com.yjj.bean.Person;
import com.yjj.bean.Red;
import com.yjj.bean.Yellow;
import com.yjj.condition.LinuxCondition;
import com.yjj.condition.WindowsCondition;
import com.yjj.factory.ColorFactoryBean;
import com.yjj.selector.MyImportBeanDefinitionRegistrar;
import com.yjj.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description: 导入组件@Import
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 16:53
 * @Version: 1.0
 */
@Configuration
@Import({Red.class, Yellow.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class BeanConfig4 {

    /**
     * 给容器中注册组件
     * 1. @ComponentScan+(@Controller,@Service,@Repository,@Component)
     * 2. @Bean[导入第三方包里面的组件]
     * 3. @Import[快速导入一个组件]
     *      1).@Import(要导入的组件)
     *      2).ImportSelector:返回需要导入的组件的全类名数组
     *      3).ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4. 使用Spring提供的FactoryBean
     *      1).默认获取到的是工厂bean调用getObject创建的对象
     *      2).要获取工厂bean本身，需要给id前边+&符号
     */

    /**
     * @Import: 快速导入某个组件，默认bean名为类全路径com.yjj.bean.Red
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

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
