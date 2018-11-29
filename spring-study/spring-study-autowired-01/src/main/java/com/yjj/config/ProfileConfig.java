package com.yjj.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/27 19:14
 * @Version: 1.0
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware{
    @Value("${db.user}")
    private String user;
    private String driverClass;
    /**
     * Profile：
     *          Spring为我们提供的可以根据当前环境，动态激活和切换一系列组件的功能
     * 开发环境、测试环境、生产环境
     * 数据源：A、B、C
     *    1.@Profile：指定组件在哪个环境下才能被注册到容器中，不指定，在任何环境下都能注册该组件
     *      加了环境标识的bean，只有在该环境下才会被注册
     *      当@Profile注解标志在类上时，该配置类下所有的bean都只在指定的环境下才会被注册
     *      没有标注@Profile注解的bean在任何环境下都会被注册
     */

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/pasture");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        driverClass=stringValueResolver.resolveStringValue("${db.driverClass}");
    }
}
