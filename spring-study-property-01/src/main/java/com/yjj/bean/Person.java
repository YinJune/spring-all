package com.yjj.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 19:12
 * @Version: 1.0
 */
public class Person {
    /**
     * 使用@Value赋值
     * 1.普通赋值
     * 2.使用SpEL表达式 #{}
     * 3.使用${}；读取配置文件中的属性值（运行环境里边的值）
     */

    @Value("1")
    private Integer id;
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.gender}")
    private String gender;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
