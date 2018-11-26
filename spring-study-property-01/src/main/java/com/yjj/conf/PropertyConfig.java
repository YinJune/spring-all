package com.yjj.conf;

import com.yjj.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 19:11
 * @Version: 1.0
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class PropertyConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
