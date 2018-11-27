package com.yjj.test;

import com.yjj.bean.Boss;
import com.yjj.config.MainConfig;
import com.yjj.bean.BookService;
import com.yjj.config.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/26 17:52
 * @Version: 1.0
 */
public class AutowiredTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        bookService.print();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    }

    /**
     * 指定环境
     * 1.命令行参数 -Dspring.profiles.active=test
     * 2.代码方式
     */
    @Test
    public void test04() {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfig.class);
        //1.无参
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        //2.指定profile
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3.注册配置文件
        applicationContext.register(ProfileConfig.class);
        //4.启动刷新容器
        applicationContext.refresh();
        String[] names=applicationContext.getBeanNamesForType(DataSource.class);
        for (String name:names){
            System.out.println(name);
        }
    }

}
