package com.yjj.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 16:32
 * @Version: 1.0
 */
@Component
public class Cat implements InitializingBean,DisposableBean {
    public Cat() {
        System.out.println("cat constructor...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat init...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }
}
